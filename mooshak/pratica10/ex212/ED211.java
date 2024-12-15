// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class ED211 {
   public static int countEven(BTree<Integer> t) {
      return countEven(t.getRoot());
   }

   public static int countEven(BTNode<Integer> n) {
      if (n == null) return 0;
      if (n.getValue() % 2 == 0) return 1 + countEven(n.getLeft()) + countEven(n.getRight());
      return countEven(n.getLeft()) + countEven(n.getRight());
   }

   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      System.out.println(countEven(t));
   }
}
