package past_year2020;

import javax.sound.sampled.SourceDataLine;

public class GenericQueue<E> {
    private Object[] queueArray;
    private int size;
    private int top;

    public GenericQueue(int queueSize){
        this.size = queueSize;
        queueArray = new Object[size];
        this.top = -1; //saying that the queue is empty
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top==size-1);
    }

    public E peek(){
        if (top==-1){
            System.out.println("Queue is empty!");
            return null;
        }
        return (E) queueArray[top];
    }

    public void enqueue(E element){
        if(isFull()){
            System.out.println("The queue is full");
            return;
        }
        queueArray[++top] = element;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
        }
        E firstOut = (E) queueArray[0];
        //shifting the value and make everything move to the front
        for(int i=0;i<top;i++){
            queueArray[i] = queueArray[i+1];
        }
        queueArray[top--] = null;
        System.out.println("Deque: " + firstOut);
    }

    public void display(){
        if(isEmpty()==true){
            System.out.println("Stack is empty");
        }

        for(int i =0;i<= top; i++){
            System.out.println("Elements are : " + queueArray[i]);
        }
    }

    public void enqueueMany(String values){
        if(isFull()){
            System.out.println("The stack is full!");
            return; 
        }
        String[] element = values.split(",");
        for(String elements : element){
            String trimmedElement = elements.trim();
            enqueue((E) trimmedElement);
        }
    }

    public void dequeueAll(){
        while(!isEmpty()){
                dequeue();
        }
    }

    public void changeOrder(int index){
        
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        if(index < 0 || index > top){
            System.out.println("The index is invalid");
            return;
        }
        //create a temp queue to hold the new queue
        E[] tempQ = (E[]) new Object[size];
        int tempTop = -1;

        //first we move the value from index all the way to the back
        for(int i = index; i<=top; i++){
            tempQ[++tempTop] = (E)queueArray[i];
        }

        //then we move the element at the front of the index to the tempQ
        for(int i =0; i < index ; i++){
            tempQ[++tempTop] = (E) queueArray[i];
        }

        //update the value for queue and top to use the temp value
        queueArray = tempQ;
        top = tempTop;

        display();
    }


    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<String>(6);
        q.enqueue("Hello");
        q.enqueueMany("all,who,wants,ice cream, or cookie");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        
        System.out.println("----------------------");
        GenericQueue<Integer> q2 = new GenericQueue<>(6);
        q2.enqueue(1000);
        q2.enqueue(2000);
        q2.enqueueMany("3000,4000 5000,6000,7000,8000,9000");
        q2.display();
        q2.dequeue();
        q2.dequeue();
        q2.enqueue(8000);
        q2.dequeueAll();
        q2.display();

       
    }
}
