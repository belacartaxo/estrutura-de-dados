import java.util.Scanner;

public class ED235{
    public static void triangulo(int n){
        for (int i = n; i > 0; i--){ //linhas
            for (int j = 0; j < n; j++){ //colunas
                if(j<i) System.out.print("#");
                else System.out.print(".");
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System. in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            triangulo(in.nextInt());
        }
    } 
}