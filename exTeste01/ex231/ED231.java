import java.util.Scanner;
public class ED231 {
    public static void flag3(int[] casos){
        int linhas = casos[casos.length-1]/100;
        int colunas = casos.length;

        for (int i = 0; i < linhas; i++ ){
            for (int j = 0; j < colunas; j++){
                if((linhas - i)*100 <= casos[j]) System.out.print("#");
                else System.out.print(".");
            }

            System.out.println();
        }
    }

    public static void flag2(int[] casos){
        double per;
        int tot = 0, consec = 0, max = 0;

        for (int i = 0; i < casos.length-1; i++){
            per = (casos[i+1] * 100.0 / casos[i]) - 100.0;
            if (per <= 5){
                if (consec == 0) tot++;
                consec++;
                if (max < consec) max = consec; 
            } else {
                consec = 0;
            }
        }
        System.out.println(tot + " " + max);
    }

    public static void flag1(int[] casos){
        int dif =casos[1]-casos[0];
        int max = dif;
        int min = dif;
        for (int i = 0; i < casos.length-1; i++){
            dif = casos[i+1]-casos[i];
            if (max < dif) max = dif;
            else if (min > dif) min = dif;
        }

        System.out.println(min+ " "+ max);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] casos = new int[n];

        for (int i = 0; i < n; i++)
            casos[i] = in.nextInt();
        int flag = in.nextInt();
        
        if (flag == 1) flag1(casos);
        else if (flag == 2) flag2(casos);
        else if (flag == 3) flag3(casos);
    }
}