import java.util.Scanner;

public class ED194{
    public static void inverte(MyStack<Integer> s1, MyStack<Integer>s2, int n){
        for (int i = 0; i < n; i++){
            s1.push(s2.pop());
        }
    }

    public static void reverse(MyStack<Integer> s, int n){
        MyStack<Integer> aux1 = new LinkedListStack<Integer>();
        MyStack<Integer> aux2 = new LinkedListStack<Integer>();
        inverte(aux1,s,n);
        inverte(aux2,aux1,n);
        inverte(s,aux2,n);
    }

    public static MyStack<Integer> addNaPilha(int[] vals){
        MyStack<Integer> p = new LinkedListStack<Integer>();
        for (int i = 0; i < vals.length; i++){
            p.push(vals[i]);
        }
        return p;
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        MyStack<Integer> p = new LinkedListStack<Integer>();
        int size = in.nextInt();
        for (int i = 0; i < size; i++)
            p.push(in.nextInt());
        System.out.println("Pilha Inicial: "+ p);
        int n = in.nextInt();
        System.out.println("Invertendo com n = " + n);
        reverse(p, n);
        System.out.println("Pilha Final: "+ p);
    }
}