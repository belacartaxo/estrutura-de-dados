import java.util.Scanner;

class Board{
    int rows;
    int cols;
    char[][] board;

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

    public void newGeneration(){
        char[][] newBoard = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                cellAnalysis(newBoard, i, j);
            }
        }
        board = newBoard;
    }

    public void cellAnalysis(char[][] newBoard, int r, int c){
        int n = neighbors(r, c);
        if (board[r][c] == 'O'){
            if (n <= 1) newBoard[r][c] = '.';
            else if (n >= 4) newBoard[r][c] = '.';
            else newBoard[r][c] = 'O';
        } else {
            if(n == 3) newBoard[r][c] = 'O';
            else newBoard[r][c] = '.';
        }
    }

    public int neighbors(int r, int c){
        int[][] directions = { {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };
        int newR;
        int newC;
        int n = 0;
        for (int i = 0; i < directions.length; i++){
            newR = r + directions[i][0];
            newC = c + directions[i][1];
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols){
                if (board[newR][newC] == 'O') n++;
            }
        }
        return n;
    }
}

class JogoDaVida{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int inter = in.nextInt();

        Board b = new Board(r, c);
        b.readBoard(in);

        for(int i = 0; i < inter; i++){
            b.newGeneration();
        }

        System.out.print(b);
    }
}