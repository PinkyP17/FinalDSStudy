package past_year2020;

public class GenericStack<E> {
    private Object[] stackArray;
    private int size;
    private int top;

    public GenericStack(int stackSize){
        this.size = stackSize;
        stackArray = new Object[size];
        top = -1; //initialize the top as - to indicate its empty
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (size==stackArray.length);
    }
    
    public E peek(){
        if (top==-1){
            System.out.println("Stack is empty!");
            return null;
        }
        return (E) stackArray[top];
    }

    public void push(E element) {
        if(top == size -1){
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++top] = element; 
    }

    public void pushMany(String values){
        if(top == size -1){
            System.out.println("Stack overflow");
            return;
        }
        String[] elements = values.split(",");
        for(String element : elements){
            String trimmedElement = element.trim();
            push((E) trimmedElement);
        }
        
    }

    public E pop(){
        if(top == -1){
            System.out.println("Stack underflow!!!");
            return null;
        }
        E poppedElement = (E)stackArray[top];
        stackArray[top--] = null;
        return poppedElement;

    }

    public E popMiddle() {
    if (top == -1) {
        System.out.println("Stack is empty");
        return null;
    }

    int middle = (top + 1) / 2;
    E middleElement = (E) stackArray[middle];

    // Shift elements to fill the gap left by removing the middle element
    for (int i = middle; i < top; i++) {
        stackArray[i] = stackArray[i + 1];
    }

    stackArray[top--] = null;
    return middleElement;
    }

    public void popAll(){
        while(!isEmpty()){
            System.out.println("Removing: " + pop());
        }
    }

    public void display(){
        if(isEmpty()==true){
            System.out.println("Stack is empty");
        }

        for(int i =0;i<= top; i++){
            System.out.println("Elements are : " + stackArray[i]);
        }
    }

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>(7);
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("brocolli,chicken sandwich,donut,french fries,juice, muruku");
        stack1.display();
        System.out.println("Pop the top of the stack : " + stack1.pop());
        System.out.println("Pop the top of the stack : " + stack1.pop());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());

        stack1.display();

        System.out.println("----------------------------------");
        GenericStack<Integer> stack2 = new GenericStack<>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
        
    }

    

}
