import java.util.Scanner;

public class ED029{
    public static void readQueue(Scanner in, int n, MyQueue<String> aviao, MyQueue<Integer> min){
        for(int i = 0; i < n; i++){
            aviao.enqueue(in.next());
            min.enqueue(in.nextInt());
        }
    }

    public static void contaAtraso(int[] atraso, MyQueue<Integer> lev, MyQueue<Integer> ate){
        int min = 1, sizeLev = lev.size(), sizeAte = ate.size();
        while (lev.size() > 0 || ate.size() > 0){
            if (ate.size() == 0 || lev.size() != 0 && lev.first() < ate.first()) {
                if (lev.first() <= min) atraso[sizeLev-lev.size()] = min - lev.dequeue();
            } else {
                if (ate.first() <= min)atraso[sizeLev + sizeAte-ate.size()] = min - ate.dequeue();
            }
            min++;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), l, a;
        MyQueue<String> aviaoLeva = new LinkedListQueue<String>();
        MyQueue<Integer> minLeva = new LinkedListQueue<Integer>();
        MyQueue<String> aviaoAter = new LinkedListQueue<String>();
        MyQueue<Integer> minAter = new LinkedListQueue<Integer>();

        for(int i = 0; i < n; i++){
            l = in.nextInt(); 
            a = in.nextInt();
            int atraso[] = new int[l+a];

            readQueue(in, l, aviaoLeva, minLeva);
            readQueue(in, a, aviaoAter, minAter);

            contaAtraso(atraso, minLeva, minAter);

            System.out.println(l + " " + a);
            for(int j = 0; j < atraso.length; j++){
                if(aviaoLeva.size() > 0) System.out.println(aviaoLeva.dequeue() + " " + atraso[j]);
                else System.out.println(aviaoAter.dequeue() + " " + atraso[j]);
            }
        }
    }
}