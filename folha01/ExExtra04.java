public class ExExtra04 {

    static void lSystem(int n){
        String s = "";
        String newS;
        while (n > 0){
            newS = "";
            if (s.isEmpty())
                s = "A";
            else{
                for (int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == 'A')
                        newS += "AB";
                    else
                        newS += "A";
                }
                s = newS;
            }
            System.out.println(s);
            n--;
        }
    }
    public static void main(String[] args) {
        lSystem(7);
    }
    
}
