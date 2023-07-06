package LinkedList;
import java.util.LinkedList;
import java.util.*;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        top = x;

        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int poppedElement = queue1.poll();
        if (!queue1.isEmpty()) {
            top = queue1.peek();
        }

        return poppedElement;
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyStack: [");

        // Create a copy of queue1 to preserve its elements
        Queue<Integer> tempQueue = new LinkedList<>(queue1);

        // Iterate over the elements in reverse order
        while (!tempQueue.isEmpty()) {
            sb.append(tempQueue.poll());
            if (!tempQueue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}

public class LC{
public static void main(String[] args) {
    MyStack swq = new MyStack();

    swq.push(10);
    swq.push(20);
    swq.push(30);

    System.out.println(swq.toString());

    System.out.println(swq.pop());

    System.out.println(swq.toString());
}
}