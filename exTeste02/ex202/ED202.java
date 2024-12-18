import java.util.Scanner;
import java.util.Arrays;

class Mapa{
    int tam;
    float dist[][];

    Mapa(int t){
        tam = t;
        dist = new float[t][t];
    }

    public void read(Scanner in){
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                dist[i][j] = in.nextFloat();
            }
        }
    }
     
    public String toString(){
        String res = "";
        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                res += dist[i][j];
                res += " ";
            }
            res += '\n';
        }
        return res;
    }

    public float findBestDistance(){
        boolean[] visited = new boolean[tam];
        return findBestDistance(0, visited, 0, 0);
    }

    public float findBestDistance(int local, boolean[] visited, float percurso, int totVisited){
        boolean[] new_visited = visited.clone();
        if(!new_visited[local]) {
            new_visited[local] = true;
            totVisited += 1;
        }
        if (totVisited == tam) return percurso + dist[local][0];

        float min = Float.MAX_VALUE;

        for (int i = 0; i < tam; i++){
            if (!visited[i]){
                float p = percurso + dist[local][i];
                if (p < min)
                    min = Math.min(min, findBestDistance(i, new_visited, p, totVisited));
            }
        }
        return min;
    }
}

public class ED202{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Mapa m = new Mapa(t);
        in.nextLine();
        in.nextLine();
        m.read(in);
        System.out.println(String.format("%.2f", m.findBestDistance()));
    }
}