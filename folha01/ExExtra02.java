public class ExExtra02 {


    static void decomposicao(int n){
        int i = 2;
        System.out.print(n + " = ");
        while(i <= n){
            if(n == i){
                System.err.print(i);
                n /= i;
            }
            else if(n % i == 0){
                System.err.print(i + " * ");
                n /= i;
            }
            else            
                i++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        decomposicao(200);
    }
}
