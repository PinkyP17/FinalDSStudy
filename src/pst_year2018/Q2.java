package pst_year2018;
class Queue{
    private Object[] queueArray;
    private int size;
    private int top; //holding the index of the front of the queue

    Queue(int size){
        this.size = size;
        queueArray = new Object[size];
        top = -1; // indincating that there is nothing int he queue
    }

    boolean isEmpty(){
        return (top==-1);
    }

    Object peek(){
        return (String) queueArray[top];
    }

    void enqueue(String data){
        if(top==size-1){
            System.out.println("Queue is overflow");
        }
        queueArray[++top] = data;
    }

    String deqeue(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        String elementSent = (String)queueArray[top];
        queueArray[top--] = null;
        return elementSent;
    }

    void display(){
        for(int i=0;i<=top;i++){
            System.out.println("Printing out the data: " + queueArray[i] + " index is [" + i + "]");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue("Hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");

        q.display();

        q.deqeue();
        q.deqeue();

        q.enqueue("10000");
        q.enqueue("20000");
        q.display();

        System.out.println(q.peek());
    }
    
}
