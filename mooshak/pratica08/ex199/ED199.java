import java.util.Scanner;

public class ED199{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        int inst = in.nextInt();
        int ini = b, fin = b;
        String baus = in.next();
        for (int i = 0; i < inst; i++){
            if(in.next().equals("D"))
                b += in.nextInt();
            else 
                b -= in.nextInt();
            if(ini > b) ini = b;
            else if (fin < b) fin = b;
        }

        int tot = 0;
        for (int i = ini - 1; i < fin; i++){
            if (baus.charAt(i) == 'T') tot++;
        }
            System.out.println(tot);
    }
}