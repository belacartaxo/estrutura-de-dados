import java.util.Scanner;

class Matriz{
    int rows;
    int cols;
    char mat[][];
    int tam;
    int ocor;

    Matriz(int r, int c){
        rows = r;
        cols = c;
        mat = new char[r][c];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sb.append(mat[i][j]);
            }
            sb.append("\n");
        }        
        return sb.toString();
    }

    public void readMatriz(Scanner in){
        String buff;
        for(int i = 0; i < rows; i++){
            buff = in.next();
            for(int j = 0; j < cols; j++){
                mat[i][j] = buff.charAt(j);
            }
        }
    }

    public void check(){
        tam = 0;
        ocor = 0;

        for(int i = 0; i < rows; i++) checkLine(i, 0, 0, 1);
        for(int j = 0; j < cols; j++) checkLine(0, j, 1, 0);
        
        System.out.println(tam + " " + ocor);
    }

    private void checkLine(int x, int y, int incx, int incy){
        int aux = 0;
        for(int xx = x, yy = y; xx < rows && yy < cols; xx += incx, yy += incy){
            if (mat[xx][yy] == '#') {
                aux ++;
            } else {
                aux = 0;
            }

            if (aux > tam){
                tam = aux;
                ocor = 1;
            } else if(aux == tam){
                ocor++;
            }
        }
    }
}

public class Contando{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Matriz mat = new Matriz(in.nextInt(), in.nextInt());
        mat.readMatriz(in);
        mat.check();
    }
}