public class Ex193{
    public <T> void encheLista(T[] listn, SinglyLinkedList<T> ln, String txt){
        for(int i = 0; i < listn.length; i++)
            ln.addLast(listn[i]);
        System.out.println(txt + ": " + ln);
    }

    public static void main(String[] args){
        Ex193 ex = new Ex193();

        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<String> l5 = new SinglyLinkedList<String>();

        Integer[] list1 = {1,2,2,2,1,3,4,2,1};
        String[] list2 = {"cc","cc","cc","cc","cc"};

        ex.encheLista(list1, l1, "Lista 1");
        l1.removeAll(1);
        System.out.println("cont - " + l1);

        ex.encheLista(list1, l2, "Lista 2");
        l2.removeAll(2);
        System.out.println("cont - " + l2);

        ex.encheLista(list1, l3, "Lista 3");
        l3.removeAll(3);
        System.out.println("cont - " + l3);

        ex.encheLista(list1, l4, "Lista 4");
        l4.removeAll(5);
        System.out.println("cont - " + l4);

        ex.encheLista(list2, l5, "Lista 5");
        l5.removeAll("cc");
        System.out.println("cont - " + l5);
    }
}