public class Ex189{
    public <T> void encheLista(T[] listn, SinglyLinkedList<T> ln, String txt){
        for(int i = 0; i < listn.length; i++)
            ln.addLast(listn[i]);
        System.out.println(txt + ": " + ln);
    }

    public static void main(String[] args){
        Ex189 ex = new Ex189();

        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Character> l2 = new SinglyLinkedList<Character>();
        SinglyLinkedList<String> l3 = new SinglyLinkedList<String>();
        SinglyLinkedList<String> l4 = new SinglyLinkedList<String>();

        Integer[] list1 = {2,4,6};
        Character[] list2 = {'a','b','c','d'};
        String[] list3 = {"estruturas","de","dados"};
        
        ex.encheLista(list1, l1, "Lista 1");
        System.out.println(l1.remove(0)+ " " + l1);
        ex.encheLista(list2, l2, "Lista 2");
        System.out.println(l2.remove(2)+ " " + l2);
        ex.encheLista(list3, l3, "Lista 3");
        System.out.println(l3.remove(3)+ " " + l3);
        ex.encheLista(list3, l4, "Lista 4");
        System.out.println(l4.remove(-1) + " " + l4);
    }
}