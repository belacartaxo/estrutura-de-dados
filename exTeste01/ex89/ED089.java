import java.util.Scanner;

class Atividade{
    int atv;
    int rend;
    Atividade(int n, int r){
        atv = n;
        rend=r;
    }

    public void addrend(int n){
        rend += n;
    }
    public String toString(){
        return atv + " " + rend;
    }
}

public class ED089{

    public static void printVet(Atividade[] vet, int size){
        for(int i = 0 ; i< size; i++){
            System.out.println(vet[i]);
        }
    }

    public static boolean add(Atividade[] atividades, int atv, int rend, int size){
        if (size == 0){
            atividades[0] = new Atividade(atv, rend);
            return true;
        } 

        Atividade aux1, aux2 = new Atividade(atv, rend);
        for(int i = 0; i < size; i++){
            if(atividades[i].atv == atv){
                atividades[i].addrend(rend);
                return false;
            } else if (atividades[i].atv > atv){
                aux1 = atividades[i];
                atividades[i] = aux2;
                aux2 = aux1;
                if(i == size-1){
                    atividades[size] = aux1;
                    return true;
                }
            }
        }
        atividades[size] = aux2;
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int tipo = in.nextInt();

        Atividade[] ativ = new Atividade[n];
        int size = 0;
        int atv, rend;

        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j <= 3; j++) in.nextLine();
   
            atv = in.nextInt();
            rend = in.nextInt();
            if(add(ativ, atv, rend, size)) size++;
        }

        if (tipo == 0) System.out.println(size);
        else if (tipo == 01) printVet(ativ, size);
    }
}