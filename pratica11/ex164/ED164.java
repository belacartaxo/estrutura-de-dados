// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED164 {
   public static void main(String[] args) {
      BSTree<String> t = new BSTree<String>();
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      
      for (int i=0; i<n; i++) t.insert(in.next());

      System.out.println(t.numberNodes());
   }
}
