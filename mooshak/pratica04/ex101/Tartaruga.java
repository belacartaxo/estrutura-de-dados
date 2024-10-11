import java.util.Scanner;

class Board{
    int rows;
    int cols;
    char[][] board;
    int x = 0;
    int y = 0;
    boolean pen = false;
    int direction = 1;
    int[][] posibleDirections = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    char[] dir = {'N', 'E', 'S', 'O'};

    Board(int r, int c){
        rows = r;
        cols = c;
        readBoard();
    }

    Board(int r, int c, Scanner in){
        rows = r;
        cols = c;
        readBoard(in);
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                res += board[i][j];
                res += " ";
            } 
            res += "\n";
        }
        return res;
    }

    public void readBoard() {
        readBoard('.'); 
    }

    public void readBoard(Object input) {
        board = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (input instanceof Character) {
                    board[i][j] = (char) input;
                } else if (input instanceof Scanner) {
                    board[i][j] = ((Scanner) input).next().charAt(0);
                }
            }
        }
    }

    public void readInstructions(Scanner in){
        String inst = in.next();
        int n;
        while (!inst.equals("end")){
            switch(inst.charAt(0)){
                case 'U':
                    pen = false;
                    break;
                case 'D':
                    pen = true;
                    break;
                case 'L':
                    left();
                    break;
                case 'R':
                    right();
                    break;
                case 'F':
                    n = in.nextInt();
                    walk(n);
                    break;
            }
            inst = in.next();
        }
    }

    private void right(){
        direction = (direction == posibleDirections.length-1) ? 0 : direction + 1; 
    }

    private void left(){
        direction = (direction == 0) ? posibleDirections.length-1 : direction - 1; 
    }

    private void walk(int n){
        if (pen){
            board[x][y] = '*';
            for (int i = 0; i < n; i++){
                validCordinate(x + posibleDirections[direction][0], y + posibleDirections[direction][1]);
                board[x][y] = '*';
            }
        } else {
            validCordinate(x + n * posibleDirections[direction][0], y + n * posibleDirections[direction][1]);
        }
    }

    private void validCordinate(int a, int b){
        if (a < 0) x = 0;
        else if (a >= cols) x = cols - 1;
        else x = a;
        if (b < 0) y = 0;
        else if (b >= rows) y = rows - 1;
        else y = b;
    }

    public void option1(){
        int porc = porcentagem();
        int lin = 0;
        int col = 0;
        for (int i = 0; i < rows; i++) lin += checkLine(i, 0, 1, 0);
        for (int j = 0; j < rows; j++) col += checkLine(0, j, 0, 1);
        System.out.println(porc + " " + lin + " " + col);
    }

    private int checkLine(int x, int y, int incx, int incy){
        for (int xx = x, yy = y; xx < rows && yy < cols; xx += incx, yy += incy){
            if (board[xx][yy] == '*') return 0;
        }
        return 1;
    }

    private int porcentagem(){
        int tot = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '*') tot++;
            }
        }
        return ((tot*100)/(rows*cols));
    }

    public void option2(Scanner in){
        int r = in.nextInt();
        int c = in.nextInt();
        Board newBoard = new Board(r, c, in);

        if (findBoard(newBoard))  System.out.println("sim");
        else System.out.println("nao");
    }

    private boolean findBoard(Board b){
        for (int i = 0; i < rows - b.rows; i++){
            for (int j = 0; j < cols - b.cols; j++){
                if(searchWord(b, i, j)) return true;
            }
        }
        return false;
    }

    private boolean searchWord(Board b, int x, int y){
        for (int i = 0; i < b.rows; i++){
            for (int j = 0; j < b.cols; j++){
                if (b.board[i][j] != board[x+i][y+j]) return false;
            }
        }
        return true;
    }



}

class Tartaruga{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int op = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();

        Board b = new Board(r, c);
        b.readInstructions(in);

        if(op == 0) System.out.println(b);
        else if(op == 1) b.option1();
        else if (op == 2) b.option2(in);        
    }
}