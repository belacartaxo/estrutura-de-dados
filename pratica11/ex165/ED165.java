// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED165 {
   public static String sum(BSTree<Integer> tree, int k) {
      return sum(tree.getRoot(), tree, k) ? "sim" : "nao";
   }

   private static boolean sum(BSTNode<Integer> n, BSTree<Integer> t, int k) {
      if (n == null) return false;
      if (n.getValue() > k) return sum(n.getLeft(), t, k);
      if (t.contains(k-n.getValue())) return true;
      return sum(n.getRight(), t, k) || sum(n.getLeft(), t, k); 
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
         System.out.println(k +": "+ sum(t, k));
      }
   }
}
