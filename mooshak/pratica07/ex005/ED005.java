import java.util.Scanner;

public class ED005{
    public static boolean calc(MyStack<Integer> num, String c){
        int a, b;
        switch(c){
            case "+":
                if(num.size() < 2) return false;
                b = num.pop(); a = num.pop();
                num.push(a + b); 
                break;
            case "-":
                if(num.size() < 2) return false;
                b = num.pop(); a = num.pop();
                num.push(a - b); 
                break;
            case "*":
                if(num.size() < 2) return false;
                b = num.pop(); a = num.pop();
                num.push(a * b); 
                break;
            case "/":
                if(num.size() < 2) return false;
                b = num.pop(); a = num.pop();
                num.push(a / b); 
                break;
            default:
                num.push(Integer.parseInt(c));
                break;
        }
        return true;
    }

    public static void cleanStack(MyStack s){
        while (s.size() != 0) s.pop();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String linha, c;
        boolean notError = true;
        MyStack<Integer> num = new LinkedListStack<Integer>();
        for (int i = 0; i < n; i++){
            linha = in.nextLine();
            Scanner lin = new Scanner(linha);
            while (lin.hasNext()){
                c = lin.next();
                notError = calc(num, c);
                if (!notError) break; //se tiver ocorrido um erro da um break
            }
            if(num.size() > 1 || !notError) {
                System.out.println("Expressao Incorrecta");
            } else{
                System.out.println(num.top());
            }
            cleanStack(num);
        }
    }
}