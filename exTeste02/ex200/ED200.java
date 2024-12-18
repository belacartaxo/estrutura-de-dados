import java.util.Scanner;
class Placa{
    int row;
    int col;
    char placa[][];
    boolean visited [][];

    Placa(int r, int c){
        row = r;
        col = c;
        placa = new char[r][c];
        visited = new boolean[r][c];
    }

    public void read(Scanner in){
        String line;
        for (int i = 0; i < row; i++){
            line = in.next();
            for (int j = 0; j < col; j++){
                placa[i][j] = line.charAt(j);
            }
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res += placa[i][j];
            }
            res += "\n";
        }
        return res;
    }

    public int maior(){
        int max = 0, c;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                c = conta(i,j);
                if (c > max) max = c;
            }
        }
        return max;
    }

    public int conta(int r, int c){
        if (r < 0 || c < 0 || r >= row || c >= col) return 0;
        if (visited[r][c] || placa[r][c] == '.') return 0;
        int cont = 1;
        visited[r][c] = true;
        cont += conta (r+1, c);
        cont += conta (r-1, c);
        cont += conta (r, c+1);
        cont += conta (r, c-1);
        cont += conta (r+1, c+1);
        cont += conta (r-1, c-1);
        cont += conta (r+1, c-1);
        cont += conta (r-1, c+1);
        return cont;
    }

}

public class ED200{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Placa p;
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            p = new Placa(in.nextInt(), in.nextInt());
            p.read(in);
            System.out.println(p.maior());
        }

        in.close();
    }
}