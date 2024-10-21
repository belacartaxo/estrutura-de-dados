class BigNumber{
    String n;

    BigNumber(String n) {
        this.n = n;
    }

    public String toString(){
        return this.n;
    }

    public boolean equals(BigNumber n) {
        if (this.n.length() != n.n.length()) return false;
        for (int i = 0; i < this.n.length(); i++){
            if(this.n.charAt(i) != n.n.charAt(i)) return false;
        }
        return true;
    }

    public BigNumber add(BigNumber n) {
        int cont = 0, n1, n2, aux, tamMax;
        int tamN1 = this.n.length(), tamN2 = n.n.length();
        String res = "";
        tamMax = (this.n.length() > n.n.length())?this.n.length():n.n.length();
        for (int i = 0; i < tamMax; i++){
            n1 = (tamN1-i-1 >= 0)?this.n.charAt(tamN1-i-1)-'0':0;
            n2 = (tamN2-i-1 >= 0)?n.n.charAt(tamN2-i-1)-'0':0;
            aux = n1 + n2 + cont;

            if(aux > 9){
                cont = 1;
                aux = aux - 10;
            }
            else {
                cont = 0;
            }

            res += aux;
        }
        if (cont != 0) res += cont;

        BigNumber newNumber = new BigNumber(new StringBuilder(res).reverse().toString());
        return newNumber;
    }

    // public BigNumber multiply(BigNumber n){

    // }

}

class TestBigNumber {
   public static void main(String[] args) {
      BigNumber n1 = new BigNumber("1234567890");
      System.out.println(n1); // Escreve "1234567890"

      BigNumber n2 = new BigNumber("42");
      BigNumber n3 = new BigNumber("1234567890");
      System.out.println(n1.equals(n2)); // Escreve "false"
      System.out.println(n1.equals(n3)); // Escreve "true"
      
      BigNumber n4 = new BigNumber("46711237126582920746212");
      BigNumber n5 = new BigNumber("8765432110");
      BigNumber n6 = n1.add(n3);
      System.out.println(n6); // Escreve "2469135780"
      BigNumber n7 = n1.add(n4);
      System.out.println(n7); // Escreve "46711237126584155314102"
      BigNumber n8 = n1.add(n5);
      System.out.println(n8); // Escreve "10000000000"

    //   BigNumber n9 = n1.multiply(n3);
    //   System.out.println(n9); // Escreve "1524157875019052100"
    //   BigNumber n10 = n1.multiply(n4);
    //   System.out.println(n10); // Escreve "57668193458655139375688174332680"
   }
}