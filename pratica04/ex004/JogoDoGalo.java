import java.util.Scanner;

class Board {
    int size;
    char board[][];

    Board(int s){
        size = s;
        board = new char[s][s];

    }

    public String toString(){
        String res = "";
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                res += board[i][j];
            }
            res += "\n";
        }
        return res;
    }

    public void readBoard(Scanner in){
        String buf;
        for (int i = 0; i < size; i++){
            buf = in.next();
            for (int j = 0; j < size; j++){
                board[i][j] = buf.charAt(j);
            }
        }
    }

    public void checkBoard(){
        for (int i = 0; i < size; i++) checkLine(i, 0, 0, 1);
        for (int j = 0; j < size; j++) checkLine(0, j, 1, 0);
        checkLine(0, 0, 1, 1);
        checkLine(0, size-1, 1, -1);

        if (complete()){
            System.out.println("Empate");
        } else {
            System.out.println("Jogo incompleto");
        }
    }

    private void checkLine(int x, int y, int incx, int incy){
        if (board[x][y] == '.') return;
        for(int i = 0, xx = x,  yy = y; i < size; i++, xx+=incx, yy+=incy)
            if(board[x][y] != board[xx][yy]) return;
        win(board[x][y]);
    }

    private boolean complete(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (board[i][j] == '.') return false;
            }
        }
        return true;
    }

    private void win(char ch){
        System.out.println("Ganhou o " + ch);
        System.exit(0);
    } 
}

class JogoDoGalo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Board b = new Board(n);
        b.readBoard(in);
        b.checkBoard();
    }
}