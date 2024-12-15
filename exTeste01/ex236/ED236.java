public class ED236{
    public static void main(String[] args){
        SinglyLinkedList<Character> newList = new SinglyLinkedList<Character>();
        newList.addLast('a');
        newList.addLast('b');
        newList.addLast('c');
        newList.addLast('d');
        newList.addLast('e');

        System.out.println(newList);
        newList.shift(4);
        System.out.println(newList);

    }
}