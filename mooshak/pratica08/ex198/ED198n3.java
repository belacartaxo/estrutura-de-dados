import java.util.Scanner;
// Complexidade O(n^3)

public class ED198n3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++)
            v[i] = in.nextInt();

        int maxSoFar = v[0]; // garante que a comparação funcione corretamente para todos os casos, já que não sabemos qual é o vamor maximo e nem o valor minimo, então o melhor sempre será o rpimeiro,pois será o maior e o menor até o momento 
        for (int i=0; i<n; i++) // Todas as posicoes iniciais possiveis
            for (int j=i; j<n; j++) { // Todas as posicoes finais possiveis
                int sum = 0;
                for (int k=i; k<=j; k++) // Calcular soma entre posicoes i e j
                sum += v[k];
                if (sum > maxSoFar) maxSoFar = sum;
            }
        System.out.println(maxSoFar);
    }
}