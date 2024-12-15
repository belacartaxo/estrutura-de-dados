public class ED232{
    public static void main(String[] args){
        SinglyLinkedList<String> newList = new SinglyLinkedList<String>();
        newList.addLast("ola");
        newList.addLast("ola");
        newList.addLast("mundo");
        newList.addLast("ola");
        
        System.out.println(newList);
       
        SinglyLinkedList<String> removeList = new SinglyLinkedList<String>();
        removeList.addLast("ola");
        newList.remove(removeList);

        System.out.println(newList);

    }
}