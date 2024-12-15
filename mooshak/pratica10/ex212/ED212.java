// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;
import java.util.Arrays;

public class ED212 {
   public static int[] sumLevels(BTree<Integer> t) {
      int s[] = new int[t.depth()+1];
      sumLevels(t.getRoot(), s, 0);
      return s;
   }

   public static void sumLevels(BTNode<Integer> n, int[] s, int p) {
      if (n == null) return;
      s[p] += n.getValue();
      sumLevels(n.getRight(), s, p+1);
      sumLevels(n.getLeft(), s, p+1);
   }

   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      System.out.println(Arrays.toString(sumLevels(t)));
   }
}
