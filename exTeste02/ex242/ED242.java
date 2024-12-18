import java.util.Scanner;
import java.util.Arrays;

class Lagos{
    int row = 0;
    int col = 0;
    char[][] lagos = new char[100][100];
    boolean visited[][];

    public void read(Scanner in){
        String line = "";
        while (in.hasNext()){
            line = in.next();
            for (int i = 0; i < line.length(); i++){
                lagos[row][i] = line.charAt(i);
            }
            row++;
        }
        col = line.length();
        visited = new boolean[row][col];
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res += lagos[i][j];
            }
            res += "\n";
        }
        return res;
    }

    public int findLago(int k){
        int n;
        int[] number_lagos = new int[1000];
        int len = 0, tot = 0; 
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (lagos[i][j] == '.'){
                    n = tam(i, j, new boolean[1]);
                    if(n > 0) {
                        number_lagos[len] = n;
                        tot += n;
                        len++;
                    }
                }
            }
        }
        Arrays.sort(number_lagos);
        for (int i = 1; i <= k; i++)
            tot -= number_lagos[1000-i];
        System.out.println(tot);
        return 0;
    }

    public int tam (int i, int j, boolean[] ocean){
        if (visited[i][j]) return 0;

        visited[i][j] = true;
        if (lagos[i][j] == '#') return 0;
        if ( i == 0 || i == row-1 || j == 0 || j == col-1) ocean[0] = true;

        int cont = 1;
        if(i+1 < row) cont += tam(i+1, j, ocean); 
        if(i-1 >= 0) cont += tam(i-1, j, ocean); 
        if(j+1 < col) cont += tam(i, j+1, ocean); 
        if(j-1 >= 0)cont += tam(i, j-1, ocean); 
        if (ocean[0]) cont = -1000; 
        return cont;
    }
}

public class ED242{
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        Lagos l = new Lagos();
        l.read(in);
        l.findLago(k);
    }
}