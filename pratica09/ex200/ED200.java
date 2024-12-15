import java.util.Scanner;

class Placa{
    char[][] placa;
    int l;
    int c; 
    int maior = 0;
    boolean visited[][];

    Placa(int lin, int col){
        l = lin;
        c = col;
        placa = new char[l][c];
        visited = new boolean[l][c];
    }

    public void readInput(Scanner in){
        String aux;
        for (int i = 0; i < l; i++) {
            aux = in.nextLine();
            for (int j = 0; j < c; j++)
                placa[i][j] = aux.charAt(j);
        }
    }

    public String toString(){
        String buf = "";
        for (int i = 0; i < l; i++){
            for (int j = 0; j < l; j++)
                buf += placa[i][j];
            buf += "\n";
        }
        return buf;
    }

    public int findMax(){
        int n;
        int max = 0;
        for (int i = 0; i < l; i++){
            for (int j = 0; j < c; j++){
                n = search(j, i);
                if (max < n) max = n;
            }
        }
        return max;

    }

    public int search(int x, int y){
        if(x < 0 || y < 0 || x >=c || y >= l) return 0;
        if (visited[y][x]) return 0;
        if (placa[y][x] == '.') return 0;
        int cont = 1;
        visited[y][x] = true;
        cont += search(x+1, y);
        cont += search(x, y+1);
        cont += search(x-1, y);
        cont += search(x, y-1);
        cont += search(x+1, y+1);
        cont += search(x+1, y-1);
        cont += search(x-1, y+1);
        cont += search(x-1, y-1);
        return cont;
    }
}

public class ED200{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l, c;
        for (int i = 0; i < n; i++){
            l = in.nextInt();
            c = in.nextInt();
            in.nextLine();
            Placa p = new Placa(l, c);
            p.readInput(in);
            System.out.println(p.findMax());
        }
    }
}