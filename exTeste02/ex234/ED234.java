// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------
import java.util.Scanner;

class ED234 {
   public static void type1(Scanner in){
      BSTree<String> t = new BSTree<String>();
      int n = in.nextInt();
      for(int i =0; i < n; i++){
         t.insert(in.next());
         in.nextInt();
      }
      System.out.println(t.numberNodes());
   }

   public static void type2(Scanner in){
      BSTMap<String, Integer> m = new BSTMap<String, Integer>();
      int n = in.nextInt();
      String s, filme = "";
      int max = 0, aux;
      for(int i =0; i < n; i++){
         s = in.next();
         in.next();
         if (m.get(s) == null) m.put(s, 1);
         else m.put(s, m.get(s)+1);

         aux = m.get(s);
         if (aux > max){
            max = aux;
            filme = s;
         }
      }
      System.out.println(filme + " " + max);
   }

      public static void type3(Scanner in){
      BSTMap<String, Integer> quant = new BSTMap<String, Integer>();
      BSTMap<String, Integer> aval = new BSTMap<String, Integer>();
      int n = in.nextInt(), v;
      String s;

      for(int i =0; i < n; i++){
         s = in.next();
         if (quant.get(s) == null) {
            quant.put(s, 1);
            aval.put(s, in.nextInt());
         } else {
            quant.put(s, quant.get(s)+1);
            aval.put(s, aval.get(s)+in.nextInt());
         }
      }

      int media; 
      for(String k: quant.keys()){
         media = aval.get(k) / quant.get(k);
         if (media >= 5) System.out.println(k);
      }

   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int type = in.nextInt();
      if (type == 1) type1(in);
      else if (type == 2) type2(in);
      else if (type == 3) type3(in);
   }
}
