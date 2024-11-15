import java.util.Scanner;

public class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
        MyQueue<Integer> q = new LinkedListQueue<Integer>();

        while (a.size() > 0 || b.size() > 0){
            if(a.size() == 0) q.enqueue(b.dequeue());
            else if(b.size() == 0) q.enqueue(a.dequeue());
            else{
                if(a.first() < b.first()) q.enqueue(a.dequeue());
                else if (b.first() < a.first()) q.enqueue(b.dequeue());
                else{
                    q.enqueue(a.dequeue());
                    q.enqueue(b.dequeue());
                }
            }
        }

        return q;
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        String linha;
        int n;

        linha = in.nextLine();
        Scanner lin1 = new Scanner(linha);
        MyQueue<Integer> a = new LinkedListQueue<Integer>(); 
        while (lin1.hasNext()){
            n = lin1.nextInt();
            a.enqueue(n);
        }

        linha = in.nextLine();
        Scanner lin2 = new Scanner(linha);
        MyQueue<Integer> b = new LinkedListQueue<Integer>(); 
        while (lin2.hasNext()){
            n = lin2.nextInt();
            b.enqueue(n);
        }

        System.out.println(merge(a, b));
    }
}