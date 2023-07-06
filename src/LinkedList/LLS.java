package LinkedList;

class Node{
    int data;
    Node nextNode;

    Node(int data){
        this.data = data;
        nextNode = null;
    }
}

class LinkedList {
    Node head;

    //add the data to the front of node
    void insertAtFront(int data){
        //Allocating a new node 
        Node new_node = new Node(data);
        //changing the position from the [head] to be [data -> head]
        new_node.nextNode = head;
        //making the head to point to the new data
        head = new_node;
    }

    //append the data to the end of the node
    void append(int data){
        //Allocating a new node
        Node new_node = new Node(data);

        if(head==null){ 
        head = new_node;
        return;
        }

        Node last = head;

        //traverse until the last node
        while(last.nextNode!=null){
            last = last.nextNode;
        }

        //this part basically saying that the next of last node(old) is the inserted data
        last.nextNode = new_node;
    }

    //inserting the data at anywhere
    void insertAfter(Node prev_node, int data){
        //check whether null or not
        if(prev_node == null){
            System.out.println("The given node can't be null");
            return;
        }

        //create a new node to add the data
        Node new_node = new Node(data);

        //interchange the next of new node and prev node
        new_node.nextNode = prev_node.nextNode;

        //point the next of prev node to the new node
        prev_node.nextNode = new_node;
    }

    void printList()
    {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }
}

public class LLS{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtFront(10); //[10]
        list.insertAtFront(9); //[9->10]
        list.insertAtFront(8); //[8->9->10]
        list.insertAtFront(7); 
        list.insertAtFront(6); 

        list.printList();

        //append 30 to the end
        list.append(30);

        list.printList();


        list.insertAfter(list.head, 69);

        list.printList();
    }
}
