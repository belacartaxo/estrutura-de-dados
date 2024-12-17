// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED172 {

   public static void main(String[] args) {
      BSTMap<String, Integer> m = new BSTMap<String, Integer>();
      Scanner in = new Scanner(System.in);
      String s;

      while (in.hasNext()) {
         s = in.next();
         if (m.get(s) == null) m.put(s, 1);
         else m.put(s, m.get(s)+1);
      }

      for (String res : m.keys()){
         System.out.println(res + ": " + m.get(res));
      }
   }
}
