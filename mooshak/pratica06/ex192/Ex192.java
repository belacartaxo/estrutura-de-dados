public class Ex192{
    public <T> void encheLista(T[] listn, SinglyLinkedList<T> ln, String txt){
        for(int i = 0; i < listn.length; i++)
            ln.addLast(listn[i]);
        System.out.println(txt + ": " + ln);
    }

    public static void main(String[] args){
        Ex192 ex = new Ex192();

        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();

        Integer[] list1 = {42,200,42,9999,42,200,42};
        String[] list2 = {"cc","cc","cc","cc","cc"};

        ex.encheLista(list1, l1, "Lista 1");
        System.out.println("cont - " + l1.count(42));
        System.out.println("cont - " + l1.count(200));
        System.out.println("cont - " + l1.count(9999));
        System.out.println("cont - " + l1.count(1));

        ex.encheLista(list2, l2, "Lista 2");
        System.out.println("cont - " + l2.count("cc"));
    }
}