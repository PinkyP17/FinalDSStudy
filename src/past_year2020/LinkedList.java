package past_year2020;
class Node{
    String data;
    int amount;
    Node nextNode;

    Node(String data, int amount){
        this.data = data;
        this.amount = amount;
        nextNode = null;
    }

}

class LL{
    private Node head;
    private Node tail;


    LL(){
        head = null;
        tail = null;
    }

    public void add(String data, int amount) {
    Node newNode = new Node(data, amount);
    if (head == null) {
        head = newNode; 
        tail = newNode;
    } else {
        tail.nextNode = newNode;
        tail = newNode;
        }
    }

    public void addAfter(String nodeName, String data, int amount){
        int index =1;
        Node use = null;
        Node current = head;
        while(current!= null){
            if(current.data.equals(nodeName)){
                use = current;
                break;
            }
            current = current.nextNode;
            index++;
        }

        if(current==null){
            System.out.println("The node does not exist");
            return;
        }
        System.out.println("Found the book: " + use.data + " at index : " + index);
        

        Node nodeAfter = new Node(data, amount);
        nodeAfter.nextNode = use.nextNode;
        use.nextNode = nodeAfter;
        System.out.println("New node added");
        
    }

    public void removeNode(String nodeName){
        Node previous = null;
        Node current = head;
        Node delete = null;
        while(current!=null){
            if(current.data.equals(nodeName)){
                delete = current;
                break;
            }
            previous = current;
            current = current.nextNode;
        }

        if(current==null){
            System.out.println("The node does not exist");
            return;
        }
        if(previous==null){
            head = delete.nextNode;
        }
        else{
            previous.nextNode = delete.nextNode;
        }
        delete.nextNode = null;
        delete = null;


    }



    void display() {
    Node current = head;
    while (current != null) {
        System.out.println("Data: " + current.data + ", Amount: " + current.amount);
        current = current.nextNode;
        }
    }


}

public class LinkedList {
    public static void main(String[] args) {
        LL myLL = new LL();

        myLL.add("Hantu", 20);
        myLL.add("Batu", 30);
        myLL.add("Jubo", 10);

        myLL.display();

        myLL.addAfter("Jubo", "Jembalang", 40);
        myLL.display();

        myLL.removeNode("Batu");
        myLL.display();
    }
    
}
