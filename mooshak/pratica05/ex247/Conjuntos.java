class ArrayListIntSet implements IntSet{
    int[] list;
    int size = 0;

    ArrayListIntSet(int x){
        list = new int[x];
    }

    public String toString(){
        String res = "{ ";
        for (int i = 0; i < size; i++){
            res += list[i] + " ";
        }
        res += "}";
        return res;
    }

    public boolean contains(int x){
        for (int i = 0; i < size; i++){
            if (list[i] == x) return true;
        }
        return false;
    }

    public boolean add(int x){
        if(!contains(x)){
            list[size] = x;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x){
        for (int i = 0; i < size; i++){
            if (list[i] == x) {
                size--;
                list[i] = list[size];
                return true;
            }
        }

        return false;
    }

    public int size(){
        return size;
    }
   
    public void clear(){
        size = 0;
    }

    public boolean equals(IntSet s){
        if (size() != s.size()) return false;
        for (int i = 0; i < size; i++){
            if (!s.contains(list[i])) return false; 
        }
        return true;    
    }

    public IntSet intersection(IntSet s){
        IntSet newS = new ArrayListIntSet(list.length); 
        for (int i = 0; i < size; i++){
            if (s.contains(list[i])) newS.add(list[i]); 
        }
        return newS;
    }
}


public class Conjuntos {
    public static void main(String[] args) {
	IntSet s1 = new ArrayListIntSet(100);
	IntSet s2 = new ArrayListIntSet(100);

	for (int i=1; i<=5; i++)
	    s1.add(i);
	System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

	for (int i=3; i<=7; i++)
	    s2.add(i);
	System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

	IntSet s3 = s1.intersection(s2);
	System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

	IntSet s4 = s2.intersection(s1);
	System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

	System.out.println("s1.equals(s2) = " + s1.equals(s2));
	System.out.println("s3.equals(s4) = " + s3.equals(s4));
    }
}