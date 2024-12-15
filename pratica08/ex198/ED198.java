import java.util.Scanner;

/*
Complexidade O(n)
Se o proximo valor for maior que a soma do valor com o best, enttão o best fica como o valor, caso contrario ficamos com a soma

O maior valor do best corresponde a melhor soma
*/

public class ED198{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++)
            v[i] = in.nextInt();

        int maxSoFar = v[0]; 
        int best = v[0];
        for (int i=1; i<n; i++){ 
            if (v[i] > v[i] + best)
                best = v[i];
            else
                best += v[i];
            if (maxSoFar < best) maxSoFar = best;
        }
        System.out.println(maxSoFar);
    }
}