import java.util.Scanner;

public class Pizza {
    static boolean achou(int n, int m, int[] arr){
        for (int i = 0; i < m; i++)
            if(n == arr[i])
                return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arrM = new int[m];
        int soma = 0, p, nIng;
        boolean pode = true;
    
        for (int i = 0; i < m; i++)
            arrM[i] = scanner.nextInt();

        p = scanner.nextInt();
        for(int i = 0; i < p; i++){
            nIng = scanner.nextInt();
            for (int j = 0; j < nIng; j++)
                if (achou(scanner.nextInt(), m, arrM))
                    pode = false;

            if (pode)
                soma++;
            else
                pode = true;
        }

        System.out.println(soma);

        scanner.close();
    }
}
