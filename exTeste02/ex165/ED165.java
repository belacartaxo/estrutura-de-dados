// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED165 {
   public static String sum(BSTree<Integer> t, int k){
      return sum(t, t.getRoot(), k) ? "sim" : "nao";
   }

   public static boolean sum(BSTree<Integer> t, BSTNode<Integer> n, int k){
      if (n == null) return false;
      if (t.contains(k - n.getValue())) return true;
      return sum(t, n.getLeft(), k) || sum(t, n.getRight(), k);
   }

   public static void main(String[] args) {
      BSTree<Integer> t = new BSTree<Integer>();
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for (int i=0; i<n; i++) t.insert(in.nextInt());

      n = in.nextInt();
      int k;
      for (int i=0; i<n; i++) {
         k = in.nextInt();
         System.out.println(k + ": " + sum(t, k));
      }
   }
}
