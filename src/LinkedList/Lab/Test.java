package LinkedList.Lab;

public class Test {
    public static void main(String[] args) {
        
        MyLinkedList<Integer> cuba = new MyLinkedList<>();
        cuba.addFirst(10);
        cuba.addLast(20);

        cuba.print();

        cuba.add(1, 69);
        cuba.add(1, 70);
        
        cuba.print();
        
    }
    
}
