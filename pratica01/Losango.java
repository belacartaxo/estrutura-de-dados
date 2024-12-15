import java.util.Scanner;

public class Losango {

    static void line(int space, int star) {
        for (int i = 0; i < space; i++)
            System.out.print(".");
        for (int i = 0; i < star; i++)
            System.out.print("#");
        for (int i = 0; i < space; i++)
            System.out.print(".");
        System.out.println();
    }
    
    static void poligon(int n){
        if (n % 2 == 0)
            System.out.println("O número deve ser ímpar!");
        else{
            int star = 1;
            int space = n/2;
            
            while (space > 0){
                line(space, star);
                space = space - 1;
                star = star + 2;
            }

            while (star >= 1){
                line(space, star);
                star = star - 2;
                space = space + 1;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        poligon(n);
        scanner.close();
    }
}
