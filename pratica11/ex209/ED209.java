// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED209 {
   public static void main(String[] args) {
      BSTree<Integer> t = new BSTree<Integer>();
      Scanner in = new Scanner(System.in);
      
      while(in.hasNext()) t.insert(in.nextInt());
      t.printInOrder();
      System.out.println(t.countBetween(5, 44));
      System.out.println(t.countBetween(7, 10));
      System.out.println(t.countBetween(0, 90));
      System.out.println(t.countBetween(60, 80));
      System.out.println(t.countBetween(8, 54));
      System.out.println(t.countBetween(2, 22));
      System.out.println(t.countBetween(2, 2));
   }
}
