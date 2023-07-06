package LinkedList.Lab;
import java.util.NoSuchElementException;
class MyLinkedList<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E item){
        Node<E> newNode = new Node<>(item, head);
        head = newNode;
        if(tail == null)
            tail = newNode;
        size++;
        
    }

    public void addLast(E item){
        Node<E> newNode = new Node<>(item, tail);
        if(tail==null)
            tail = newNode;
        else
            tail.next = newNode;
        
        tail = newNode;
        size++;
    }

    public void add(int index, E item){
        checkPositionIndex(index);
        if(index==0){
            addFirst(item);
        }

        else if(index==size){
            addLast(item);
        }
        else{
            Node<E> current = head;
            for(int i=0;i<index;i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(item, temp);
            size++;
        }
    }







    //all error checker

     /**
     * Tells if the argument is the index of an existing element.
     */
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

    public boolean isPositionIndex(int index){
        return index >=0 && index <=size;
    }

    private void checkElementIndex(int index) {
		if(!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));	
	}

    public void checkPositionIndex(int index){
        if(!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}


    public void print() {
		if(head == null && tail == null) {
			System.out.println("[ ]");
		} 
		else {
			Node<E> node = head;
			System.out.print("[");
			for(int i = 0; i < size; i++) {
				System.out.print(node.element + ((i == size - 1) ? "" : ", "));
				node = node.next;
			}
			System.out.println("]");
		}
	}



}



