import java.util.Scanner;

public class Estatisticas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int num = scanner.nextInt();;
        int max = num, min = num;
        float soma = num;

        for(int i = 0; i < n-1; i++){
            num = scanner.nextInt();
            soma += num;
            if(num > max)
                max = num;
            if (num < min)
                min = num;
        }
        System.out.println(String.format("%.2f",(soma / n)));
        System.out.println(max - min);
        scanner.close();
    }
}
