import java.util.Scanner;

//complexidade O(n^2)
public class ED198{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++)
            v[i] = in.nextInt();

        int maxSoFar = v[0]; 
        for (int i=0; i<n; i++){ // Todas as posicoes iniciais possiveis
            int sum = v[i]; // fazendo a soma de soma[i..j] pata i=j
            if (sum > maxSoFar) maxSoFar = sum; //verificando novamente pois v[i] já pe uma soma
            for (int j=i; j<n-1; j++) { // Todas as posicoes finais possiveis 
                // o loop deve ir até n-1 pois pois na soma já somamos o proximo elemento
                sum += v[j+1]; //soma[i..j] + v[j]
                
                if (sum > maxSoFar) maxSoFar = sum;
            }
        }
        System.out.println(maxSoFar);
    }
}