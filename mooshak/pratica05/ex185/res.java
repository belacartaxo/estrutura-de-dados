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

    public BigNumber multiply(BigNumber n){
        int cont = 0, n1, n2, aux;
        int tamN1 = this.n.length(), tamN2 = n.n.length();
        String res;
        BigNumber newNumber = new BigNumber("0"), auxNumber1;
        for (int i = 0; i < tamN2; i++){
            n2 = n.n.charAt(tamN2-i-1)-'0';
            res = "";
            for (int k = 0; k < i; k++) res += "0";
            for (int j = 0; j < tamN1; j++){
                n1 = this.n.charAt(tamN1-j-1)-'0';
                aux = n1 * n2 + cont;
                if(aux > 9){
                    cont = aux/10;
                    aux = aux%10;
                }
                else {
                    cont = 0;
                }
                res += aux;
            }
            
            if (cont != 0) res += cont;
            cont = 0;

            auxNumber1 = new BigNumber(new StringBuilder(res).reverse().toString());

            newNumber = newNumber.add(auxNumber1);
        }

        return newNumber;
    }

}