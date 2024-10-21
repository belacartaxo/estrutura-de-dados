class BooleanArrayIntSet implements IntSet{
    boolean[] list;
    int size = 0;

    BooleanArrayIntSet(int x){
        list = new boolean[x];
    }

    public String toString(){
        String res = "{ ";
        for (int i = 0; i < list.length; i++){
            if(list[i]) res += (i+1) + " ";
        }
        res += "}";
        return res;
    }

    public boolean contains(int x){
        return list[x-1];
    }

    public boolean add(int x){
        if(!contains(x)){
            list[x-1] = true;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x){
        if (contains(x)) {
            size--;
            list[x-1] = false;
            return true;
        }

        return false;
    }

    public int size(){
        return size;
    }
   
    public void clear(){
        size = 0;
        for (int i = 0; i < list.length; i++){
            list[i] = false; 
        }        
    }

    public boolean equals(IntSet s){
        if (size() != s.size()) return false;
        for (int i = 0; i < list.length; i++){
            if (list[i])
                if (!s.contains(i+1)) return false; 
        }
        return true;    
    }

    public IntSet intersection(IntSet s){
        IntSet newS = new BooleanArrayIntSet(list.length); 
        for (int i = 0; i < list.length; i++){
            if (list[i])
                if (s.contains(i+1)) newS.add(i+1); 
        }
        return newS;
    }
}


public class Conjuntos {
    public static void main(String[] args) {
        int n = 1000000;                      
        IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
        boolean tmp;
            
        System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.add(i);

        System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.add(i);

        System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
        for (int i=1; i<=n; i++)
            tmp = s.contains(i);

        System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.remove(i);
        
    }
}