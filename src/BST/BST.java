package BST;

class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }
}

class QueueNode<E> {
    TreeNode<E> node;
    QueueNode<E> next;

    public QueueNode(TreeNode<E> node){
        this.node = node;
        next = null;
    }
}

class CustomQueue<E> {
    QueueNode<E> front;
    QueueNode<E> rear;

    public CustomQueue(){
        front = null;
        rear = null;
    }

    public void enqueue(TreeNode<E> node) {
        QueueNode<E> newNode = new QueueNode(node);
        if( rear == null){
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public TreeNode<E> dequeue(){
        if(front == null)
            return null;

        
            TreeNode<E> node = front.node;
            front = front.next;
            if(front == null)
                rear = null;
            
            return node;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public boolean search(E element) {
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left; // Go left
            } else if (element.compareTo(current.element) > 0) {
                current = current.right; // Go right
            } else { // Element matches current.element
                return true; // Element is found
            }
        }
        return false; // Element is not in the tree
    }

    public void insert(E element) {
        if (root == null) {
            root = new TreeNode<>(element);
        } else {
            TreeNode<E> current = root;
            TreeNode<E> parent;

            while (true) {
                parent = current;

                if (element.compareTo(current.element) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new TreeNode<>(element);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new TreeNode<>(element);
                        return;
                    }
                }
            }
        }
    }
    
    //Left, Root , Right
    public void inOrder(TreeNode node){
        if(node!=null){
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
        }
    }

    //Node, left, right
    public void preOrder(TreeNode node){
        if(node!=null){
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
        }
    }

    //Lefi, right, node
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.element);
        }
    }

    public void breadthFirstSearch(TreeNode<E> root) {
        if (root == null)
            return;

        CustomQueue<E> queue = new CustomQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode<E> node = queue.dequeue();
            System.out.println(node.element);

            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
    }

    public static void main(String[] args) {
        BST<Integer> test = new BST<Integer>();

        test.insert(30);
        test.insert(15);
        test.insert(35);
        test.insert(7);
        test.insert(16);
        test.insert(35);
        test.insert(33);
        test.insert(40);
        test.insert(37);
        test.insert(42);

        /* 
        System.out.println("Pre order test:");
        test.preOrder(test.root);
        System.out.println("In order test:");
        test.inOrder(test.root);
        System.out.println("Post order test:");
        test.postOrder(test.root);
        */
        
        System.out.println("Breadth-first search test:");
        test.breadthFirstSearch(test.root);
    }
}

