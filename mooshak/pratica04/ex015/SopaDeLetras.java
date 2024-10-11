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

    public void readWords(Scanner in, int w){
        String words = new String[w];
        for(int i = 0; i < w; i++)
            words[i] = in.next();
    }

    public void searchWords(String[] words){
        Boolean wordsBool = new Boolean[w];
        for (int i = 0; i < rows; i++) checkline(wordsBool, buildLine(i, 0, 0, 1), true, i);
        for (int j = 0; j < cols; j++) checkline(wordsBool, buildLine(0, j, 1, 0), false, j);
    }

    private void checkLine(Boolean[] wordsBool, String line, boolean rol, int n){
        int ind;
        for (int i = 0; i < words.length(); i++){
            ind = findWord(line, word[i])
            if (ind != -1) {

            }
            
        }
    }

    private void foundWord(Boolean[] wordsBool, int size, int x, int y, int incx, int incy){
        for (int i = ind; i < size; i++){
            wordsBool[xx][yy]
        }
    }

    private void buildLine(int x, int y, int incx, int incy, int size){
        String buf = "";
        for(int i = 0, xx = x, yy = y; i < size; i++, xx += incx, yy += incy){
            buf += board[xx][yy];
        }
        r = buf;
    }

    private int findWord(String line, String w){
        int ind = 0;
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == w.charAt(ind)){
                ind++;
            } else if (ind != 0) {
                ind = 0;
            }

            if (ind == w.length.length) {
                return i - ind; // + 1????
            }
        }
        return -1;
    }
}

class SopaDeLetras {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();

        Board b = new Board(r, c);
        b.readBoard(in);

        int w = in.nextInt();
        b.readWords(in, w);


        searchWords(words);
    }
}