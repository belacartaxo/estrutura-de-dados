import java.util.Scanner;

public class ED222{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++)
            v[i] = in.nextInt();
            
        int tot = 0, consec = 0;
        double sat = Math.ceil(k/2.0);

        for (int i = 0; i < n; i++){
            if(v[i] >= t) consec++; 

            if(i+1 >= k){
                if (i >= k && v[i-k] >= t) consec--;
                if(consec >= sat) tot++;
            }
        }
        System.out.println(tot);
    }
}