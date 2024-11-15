import java.util.Scanner;

public class ED194{
    public static int contem(Char[] lista, char c){
        for (int i = 0; i < lista.length; i++)
            if(c == lista[i]) return i;
        return -1;
    }
    public static boolean balanced(String s) {
        MyStack<Character> p = new LinkedListStack<Character>();  
        char[] simbFecho = new char[]{')', "]"};
        char[] simbAber = new char[]{'(', "["};
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(contem(simbFecho, c) != -1){ // é simbolo que fecha
                if (p.pop() != simbAber[contem(simbFecho, c)]) return false;
            } else {
                p.push(c);
            }
        }
        return true;
    }

    public static void main (String[] args){
        ED195.balanced("([()])");
        ED195.balanced("[()()]");
        ED195.balanced("(()]");
        ED195.balanced("[()[])");
        ED195.balanced("[()[]");
    }
}