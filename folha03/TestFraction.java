    class Fraction{
        int num;
        int den;
        int inteiro;

        Fraction(int n, int d){
            num = n;
            den = d;
            simplify();
        }

        public String toString(){
            simplify();
            if(inteiro == 0) return num + "/" + den;
            if(num == 0) return String.valueOf(inteiro);
            return inteiro + " + " + num + "/" + den;
        }

        private int algEuclides(int a, int b){
            int aux = a % b;
            while (aux > 1){
                a = b;
                b = aux;
                aux = a % b;
            }

            if (aux == 0) return b;
            return 1;
        } 

        private void partInt(){
            if(num >= den){
                inteiro = num / den;
                num = num % den;
            }
        }

        public Fraction add(Fraction f){
            int numRes = (num + inteiro * den) * f.den + (f.num + f.inteiro * f.den) * den;
            int denRes = den * f.den;
            Fraction frac = new Fraction(numRes, denRes);
            return frac;
        }

        public Fraction mult(Fraction f){
            int numRes = (num + inteiro * den) * (f.num + f.inteiro * f.den);
            int denRes = den * f.den;
            Fraction frac = new Fraction(numRes, denRes);
            return frac;
        }

        public void simplify(){
            partInt();
            int mdc = algEuclides(num, den);

            if (mdc != 0){
                num = num/mdc;
                den = den/mdc;
            }
        }
    }

public class TestFraction{
    public static void main(String[] args){
        Fraction f1 = new Fraction(18, 48);
        System.out.println(f1);
        Fraction f2 = new Fraction(18, 6);
        System.out.println(f2);
        Fraction f3 = new Fraction(14, 6);
        System.out.println(f3);

        System.out.println(f3.add(f1));
        System.out.println(f3.mult(f1));
    }
}