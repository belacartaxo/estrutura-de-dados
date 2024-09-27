import java.util.Scanner;

public class Palindromo {
    static String palindrom(String str){
        str = str.toLowerCase();
        int i = 0;
        int i2 = str.length();

        while ( i <= str.length()/2){
            while (i < i2 && !Character.isLetterOrDigit(str.charAt(i))) 
                i++;
    
            while (i < i2 && !Character.isLetterOrDigit(str.charAt(i2-1))) 
                i2--;

            if (i < i2 && str.charAt(i) != str.charAt(i2-1) )
                return "nao";
            i++;
            i2--;
        }

        return "sim";
    }
    public static void main(String[] args) {
        palindrom("o bolo d lobo");
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++){
            String str = scanner.nextLine();
            arr[i] = palindrom(str);
        }

        System.out.println(n);

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);

        scanner.close();
    }
}
