import java.util.Scanner;

public class Primos {

    static boolean checkPrimo(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ini = scanner.nextInt();
        int fim = scanner.nextInt();
        int soma = 0;
        boolean[] primos = new boolean[fim+1]; 

        for (int i = 0; i < fim - 1 ; i++){
            primos[i] = true;
        }

        for (int i = 2; i * i <= fim; i++){
            if(primos[i - 2]){
                for (int j = (i * 2) - 2; j < fim - 1; j += i){
                    primos[j] = false; 
                }
            }
        }

        for (int i = ini - 2; i < fim - 1; i++){
            if (primos[i]){
                soma++;
                //System.out.println(i+1);
            }
        }

        System.out.println(soma);
        scanner.close();
    }
}
