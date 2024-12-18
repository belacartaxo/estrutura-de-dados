import java.util.Scanner;

class Playlist{
    int mus[];
    int target;

    Playlist(int n, int t){
        mus = new int[n];
        target = t;
    }

    public int findTime() {
        return betterTime(0, 0);
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    public int betterTime(int ind, int soma) {
        if (ind >= mus.length) return soma;
        if (soma + mus[ind] > target) return betterTime(ind+1, soma);
        return Math.max(betterTime(ind+1, soma), betterTime(ind+1, soma + mus[ind]));
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
        System.out.println(m.findTime());
    }
}