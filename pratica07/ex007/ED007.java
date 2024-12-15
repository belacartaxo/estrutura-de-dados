import java.util.Scanner;

public class ED007{
    public static int contem(String[] lista, String c){
        for (int i = 0; i < lista.length; i++)
            if(c.equals(lista[i])) return i;
        return -1;
    }

    public static void balanced(String s) {
        MyStack<String> p = new LinkedListStack<String>();  
        String[] simbFecho = new String[]{")", "]"};
        String[] simbAber = new String[]{"(", "["};
        String c;
        Scanner lin = new Scanner(s);
        int i = -1;
        //if (s.length() % 2 != 0) return false;
        while (lin.hasNext()){
            c = lin.next();
            i += c.length();
            if(contem(simbFecho, c) != -1){ // é simbolo que fecha
                if (p.size() == 0 || !p.pop().equals(simbAber[contem(simbFecho, c)])) {
                    System.out.println("Erro na posicao "+i);
                    return;
                }
            } else if(contem(simbAber, c) != -1) { // é simbolo que abre
                p.push(c);
            }
            i++;
        }
        if (p.size() != 0){
            System.out.println("Ficam parenteses por fechar");
            return;
        }
        System.out.println("Expressao bem formada");
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String linha;
        for (int i = 0; i < n; i++){
            linha = in.nextLine();
            balanced(linha);
        }
    }
}