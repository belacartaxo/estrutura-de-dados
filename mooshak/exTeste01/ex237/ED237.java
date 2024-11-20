import java.util.Scanner;

class Process{
    String name;
    int time;

    Process(String s, int t){
        name=s;
        time = t;
    }

    public String toString(){
        return name + " " + time;
    }
}


public class ED237{
    public static void roundRobin(int t, CircularLinkedList<Process> processos){
        Process p;
        int time = 0, i = 0;
        
        while (processos.size() > 0){
            p = processos.getFirst();
            i++;
            if (p.time > t){
                p.time = p.time - t;
                processos.removeFirst();
                processos.addLast(p);
                time += t;
            } else{
                processos.removeFirst();
                time += p.time;
                System.out.println(p.name + " " + time + " " + i);
            }
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CircularLinkedList<Process> processos = new CircularLinkedList<Process>();

        int t = in.nextInt();
        int n = in. nextInt();

        for(int i = 0; i < n; i++) {
            processos.addLast(new Process(in.next(), in.nextInt()));
        }

        roundRobin(t, processos);
    }
}