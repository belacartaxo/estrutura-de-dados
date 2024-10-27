public class Ex190{
    public <T> void encheLista(T[] listn, SinglyLinkedList<T> ln, String txt){
        for(int i = 0; i < listn.length; i++)
            ln.addLast(listn[i]);
        System.out.println(txt + ": " + ln);
    }

    public static void main(String[] args){
        Ex190 ex = new Ex190();

        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Character> l2 = new SinglyLinkedList<Character>();
        SinglyLinkedList<String> l3 = new SinglyLinkedList<String>();
        SinglyLinkedList<String> l4 = new SinglyLinkedList<String>();

        Integer[] list1 = {2,4,6,8};
        Character[] list2 = {};
        String[] list3 = {"estruturas","de","dados"};
        
        ex.encheLista(list1, l1, "Lista 1");
        System.out.println("copia - " + l1.copy());
        ex.encheLista(list2, l2, "Lista 2");
        System.out.println("copia - " + l2.copy());
        ex.encheLista(list3, l3, "Lista 3");
        System.out.println("copia - " + l3.copy());

    }
}