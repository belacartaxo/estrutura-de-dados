import java.util.Scanner;

class Playlist{
    int mus[];
    int max = 0;
    int target;

    Playlist(int n, int t){
        mus = new int[n];
        target = t;
    }

    public void findTime() {
        boolean used[] = new boolean[mus.length]; 
        betterTime(0, used, 0, 0); // chamar funcao recursiva
        System.out.println(max);
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    public void betterTime(int currentDepth, boolean[] isUsed, int currentSum, int previousSum) {
        if (currentSum > target) {
            max = Math.max(max, previousSum); // Atualiza max se necessário
            return;
        }
        
        if (currentDepth == mus.length || currentSum == target) {
            max = Math.max(max, currentSum); // Atualiza max se necessário
            return;
        }
        
        for (int i = 0; i < mus.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                betterTime(currentDepth + 1, isUsed, currentSum + mus[i], currentSum);
                isUsed[i] = false; // Backtracking
            }
        }
    }


}

public class ED201{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tem = in.nextInt();
        int n = in.nextInt();
        Playlist m = new Playlist(n, tem);
        for(int i = 0; i< n; i ++)
            m.mus[i] = in.nextInt();
        m.findTime();
    }
}