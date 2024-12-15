// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }


   public SinglyLinkedList reverse(){
      SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
      if (size == 0) return newList;
      Node<T> cur = first;
      newList.addFirst(cur.getValue());

      for (int i=0; i< size-1; i++){
         cur = cur.getNext();
         newList.addFirst(cur.getValue());
      }

      return newList;
   }

   public int[] occurrences(T elem) {
      SinglyLinkedList<Integer> ocor = new SinglyLinkedList<Integer>();
      Node<T> cur = first;
      if (cur.getValue().equals(elem)) ocor.addLast(0);
      
      for (int i=1; i < size; i++){
         cur = cur.getNext();
         if (cur.getValue().equals(elem)) ocor.addLast(i);
      }

      if (ocor.size() == 0) return null;

      int[] res = new int[ocor.size()];

      for (int i = 0; i < res.length; i++){
         res[i] = ocor.getFirst();
         ocor.removeFirst();
      }

      return res;
   }

   private Node<T> first(){
      return first;
   }

   public void remove(SinglyLinkedList<T> toRemove) {
      Node<T> remove = toRemove.first();
      Node<T> cur = first;
      Node<T> ant = first;
      int s;
      
      for(int i = 0; i < toRemove.size(); i++){ // itera sobre a lista dos valores que serão removidos
         cur = first;
         s = 1;
         while (s <= size){
            if(cur.getValue().equals(remove.getValue())){
               if (cur == first) first = cur.getNext();
               else ant.setNext(cur.getNext());
               size--;
            } else {
               ant = cur;
               s++;
            }
            cur = cur.getNext();
         }
         remove = remove.getNext();
      }
   }

}