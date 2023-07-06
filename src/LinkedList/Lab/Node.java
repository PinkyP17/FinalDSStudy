package LinkedList.Lab;

public class Node<E>{
    E element;
    Node<E> next;

    public Node(){
        this.element = null;
        this.next = null;
    }

    public Node(E item,Node<E> next){
        this.element = item;
        this.next = next;
    }

    /* 
    public E getElement(){
        return element;
    }

    public void setItem(E item){
        this.element = item;
    }

    public Node<E> getNext(){
        return next;
    }

    
    public void next(Node<E> next){
        this.next = next;
    }
    */

}
