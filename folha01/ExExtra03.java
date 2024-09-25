public class ExExtra03 {
    static int count(String s, char c){
        int soma = 0;
        s = s.toLowerCase();
        c = Character.toLowerCase(c);
        for (int i = 0; i < s.length(); i++)
            if(s.charAt(i) == c)
                soma++;
        return soma;
    }
    public static void main(String[] args) {
        System.out.println(count("AlgoritmO", 'O'));
    }
}
