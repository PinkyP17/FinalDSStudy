package past_year2019;

public class GenericStack<E> {
    private Object[] stackArray;
    private int size;
    private int top; //will hold the first/top value of the stack

    GenericStack(int arraySize){
        this.size = arraySize;
        stackArray = new Object[size];
        top = -1; //when top =-1, the stack is empty
    }

    boolean isEmpty(){
        return (top==-1);
    }

    boolean isFull(){
        return (top==size-1);
    }

    E peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        return (E)stackArray[top];
    }

    void push(E element){
        if(isFull()){
            System.out.println("The stack is overflow");
        }
        stackArray[++top] = element;
    }

    void pushMany(String value){
        if(isFull()){
            System.out.println("The stack is overflow");
        }

        String[] elements = value.split(",");
        for(String element : elements){
            String trimmedElement = element.trim();
            System.out.println("Push: " + trimmedElement);
            push((E) trimmedElement);
        }
    }

    E pop(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        E poppedElement = (E) stackArray[top];
        stackArray[top--] = null;
        return poppedElement;
    }

    void popAll(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        while(!isEmpty()){
            System.out.println("Popped : " + pop());
        }
    }

    void display(){
        if(isEmpty()){
            System.out.println("The stack is empty");
        }
        System.out.println("There are " + (top+1) + " items in the stack. Displaying..." );
        for(int i=0;i<=top;i++){
            System.out.println("Elements : " + stackArray[i]);
        }
    }

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>(5);
        stack1.push("one");
        stack1.display();

        stack1.pushMany("two,three four,five,six seven");
        stack1.display();

        stack1.pop();
        stack1.pop();
    }
}
