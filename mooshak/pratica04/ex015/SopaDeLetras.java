import java.util.Scanner;

class Board {
    int rows;
    int cols;
    char board[][];
    String[] words;

    Board(int r, int c){
        rows = r;
        cols = c;
        board = new char[r][c];
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                res += board[i][j];
            }
            res += "\n";
        }
        return res;
    }

    public void readBoard(Scanner in){
        String buf;
        for(int i = 0; i < rows; i++){
            buf = in.next();
            for(int j = 0; j < cols; j++){
                board[i][j] = buf.charAt(j);
            }
        }
    }

    public void createBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] = '.';
            }
        }
    }

    public Board searchWords(String[] words, int w){
        Board b = new Board(rows, cols);
        String reverso;
        b.createBoard();
        
        for(int i = 0; i < rows || i < cols; i++){
            if (i < rows) checkLine(b, words, i, 0, 0, 1, "cols", cols);
            if (i < cols) checkLine(b, words, 0, i, 1, 0, "rows", rows);
        }

        return b;
    }

    public void checkLine(Board b, String[] words, int x, int y, int incx, int incy, String type, int size){
        String line = "";
        int ind;
        String str;
        for(int i = 0, xx = x, yy = y; i < size; i++, xx +=incx, yy += incy){
            line += board[xx][yy];
        }
        
        for (int w = 0; w < words.length; w++){
            str = words[w];
            ind = line.indexOf(str);

            if (ind != -1) {
                changeLine(b, x, y, incx, incy, str.length(), ind, type);
                continue;
            }

            ind = line.indexOf(new StringBuilder(str).reverse().toString());
            if (ind != -1) {
                changeLine(b, x, y, incx, incy, str.length(), ind, type);
            }
        }
    }

    public void changeLine(Board b, int x, int y, int incx, int incy, int sizeW, int ind, String type){
        if (type == "rows") x = ind;
        else y = ind;
        preencheBoard(b, x, y, incx, incy, sizeW);
    }

    public void preencheBoard(Board b, int x, int y, int incx, int incy, int sizeW){
        for(int i = 0, xx = x, yy = y; i < sizeW; i++, xx += incx, yy += incy){
            b.board[xx][yy] = board[xx][yy];
        }
    }
}

class SopaDeLetras {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt(), c = in.nextInt(), n = 1, w;
        Board b, newB;

        while (r != 0 && c != 0){
            b = new Board(r, c);
            b.readBoard(in);

            w = in.nextInt();

            String[] words = new String[w];
            for(int i = 0; i < w; i++)
                words[i] = in.next();

            newB = b.searchWords(words, w);
            System.out.println("Input #" + n);
            System.out.print(newB);
            r = in.nextInt();
            c = in.nextInt();
            n++;
        }
    }
}