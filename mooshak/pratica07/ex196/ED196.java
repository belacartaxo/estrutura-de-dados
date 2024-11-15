import java.util.Scanner;

public class ED196{
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
        String nome, fila;
        while (q.size() > 0){
            nome = q.dequeue();
            fila = q.dequeue();
            if (fila.equals("A")) a.enqueue(nome);
            else if (fila.equals("B")) b.enqueue(nome);
            else if (fila.equals("X")){
                if(a.size() < b.size()) a.enqueue(nome);
                else if(b.size() < a.size()) b.enqueue(nome);
            }
        }
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        MyQueue<String> q = new 
        LinkedListQueue<String>(); 
        String s;
        while (in.hasNext()){
            s = in.next();
            q.enqueue(s);
        }

        MyQueue<String> a = new LinkedListQueue<String>();
        MyQueue<String> b = new LinkedListQueue<String>();

        process(q, a, b);
        System.out.println(q);
        System.out.println(a);
        System.out.println(b);
    }
}