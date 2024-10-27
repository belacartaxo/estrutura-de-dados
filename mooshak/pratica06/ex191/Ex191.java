public class Ex191{
    public <T> void encheLista(T[] listn, SinglyLinkedList<T> ln, String txt){
        for(int i = 0; i < listn.length; i++)
            ln.addLast(listn[i]);
        System.out.println(txt + ": " + ln);
    }

    public static void main(String[] args){
        Ex191 ex = new Ex191();

        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Character> l2 = new SinglyLinkedList<Character>();
        SinglyLinkedList<String> l3 = new SinglyLinkedList<String>();
        SinglyLinkedList<Character> l4 = new SinglyLinkedList<Character>();

        Integer[] list1 = {2,4,6,8};
        Character[] list2 = {};
        String[] list3 = {"estruturas","de","dados"};
        Character[] list4 = {'a','b','c','d'};

        ex.encheLista(list1, l1, "Lista 1");
        l1.duplicate();
        System.out.println("dup - " + l1);

        ex.encheLista(list2, l2, "Lista 2");
        l2.duplicate();
        System.out.println("dup - " + l2);

        ex.encheLista(list3, l3, "Lista 3");
        l3.duplicate();
        System.out.println("dup - " + l3);
        
        ex.encheLista(list4, l4, "Lista 4");
        l4.duplicate();
        System.out.println("dup - " + l4);
    }
}