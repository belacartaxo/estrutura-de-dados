import java.util.Scanner;
import java.util.Random;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   public void rand(int a, int b) {
      Random rand = new Random();
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = rand.nextInt(b - a + 1) + a;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
   
   public static Matrix identity(int n){
      Matrix m = new Matrix(n, n);

      for(int i = 0; i < n; i++){
         for(int j = 0; j < n; j++){
            if(i == j){
               m.data[i][j] = 1;
            }
            else {
               m.data[i][j] = 0;
            }
         }
      }

      return m;
   }

   public Matrix transpose(){
      Matrix m = new Matrix(cols, rows);

      for(int i = 0; i < rows; i++){
         for(int j = 0; j < cols; j++){
            m.data[j][i] = data[i][j];
         }
      }

      return m;
   }

   public Matrix sum(Matrix m){
      Matrix resM = new Matrix(rows,cols);

      for(int i = 0; i < rows; i++){
         for(int j = 0; j < cols; j++){
            resM.data[i][j] = data[i][j] + m.data[i][j];
         }
      }

      return resM;
   }

   public Matrix multiply(Matrix m){
      Matrix resM = new Matrix(rows, m.cols);
      int aux = 0;

      for(int x = 0; x < rows; x++){
         for(int y = 0; y < m.cols; y++){
            for(int z = 0; z < cols; z++){
               aux += data[x][z] * m.data[z][y];
            }
            resM.data[x][y] = aux;
            aux = 0;
         }
      }


      return resM;
   }
}

public class TestMatrix {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      Matrix m1 = new Matrix(5, 7);
      m1.rand(5, 10);
      System.out.println(m1);
   }    
}