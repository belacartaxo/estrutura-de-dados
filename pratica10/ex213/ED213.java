// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;


public class ED213 {
   private static class Result{
      int sum;
      String path;

      Result (int s, String p){
         sum = s;
         path = p;
      }
   }

   public static String maxSum(BTree<Integer> t) {
      return maxSum(t.getRoot(), 0, "").path;
   }

   public static Result maxSum(BTNode<Integer> n, int sum, String path) {
      if (n == null) return new Result(sum, path.substring(0, path.length()-1));
      Result r = maxSum(n.getRight(), sum+n.getValue(), path+"D");
      Result l = maxSum(n.getLeft(), sum+n.getValue(), path+"E");
      if (r.sum == Math.max(r.sum, l.sum)) return r;
      return l;
   }

   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      System.out.println(maxSum(t));
   }
}
