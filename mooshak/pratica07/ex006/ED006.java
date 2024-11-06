import java.util.Scanner;

class Game {
    int totP;
    int palavras;
    CircularLinkedList<String> pessoas = new CircularLinkedList<String>();

    Game(int r, String[] p){
        palavras = r;
        totP = Integer.parseInt(p[0]);

        for (int i = 1; i <= totP; i++)
            pessoas.addLast(p[i]);
    }

    public String start(){
        for (int i = 0; i < totP-1; i++){
            for (int j = 0; j < palavras-1; j++){
                pessoas.rotate();
            }
            pessoas.removeFirst();
        }
        String perdedor = pessoas.getFirst();

        if (perdedor.equals("Carlos")) return "O Carlos nao se livrou";
        return ("O Carlos livrou-se (coitado do " + perdedor +"!)");
    }

}

public class ED006{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String frase, pes;
            
        for(int i = 0; i < n; i++){
            frase = in.nextLine();
            String[] fraseList = frase.trim().split("\\s+");
            
            pes = in.nextLine();
            String[] pesList = pes.trim().split("\\s+");

            Game game = new Game(fraseList.length, pesList);
            System.out.println(game.start());
        }
    }
}