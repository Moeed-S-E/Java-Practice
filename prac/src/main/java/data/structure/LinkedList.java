package data.structure;

public class LinkedList {
    Node headNode;
    public LinkedList(){
        headNode = null;
    }
    //Insert at End
    public void append(int data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
        }else{
            Node temp = headNode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    //Insert at Start
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = headNode;
        headNode = newNode;
    }
    //Delete with specific data
    public void delete(int data) {
        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }
        // If the head node itself contains the data
        if (headNode.data == data) {
            headNode = headNode.next; // Move the head to the next node
            return;
        }
        // Find the node to delete
        Node temp = headNode;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next; // Bypass the node to delete
        } else {
            System.out.println("Node with data " + data + " not found");
        }
    }
    public void insertAt(int position, int data) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        
        Node newNode = new Node(data);
        
        if (position == 0) {
            newNode.next = headNode;
            headNode = newNode;
            return;
        }

        Node temp = headNode;
        int currentIndex = 0;
        while (temp != null && currentIndex < position - 1) {
            temp = temp.next;
            currentIndex++;
        }   
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }  
        
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void display() {
        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = headNode;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public Node search(int target) {
        Node start = headNode;
        Node end = null;
        while (start != end) {
            Node middle = getMiddleNode(start,end);
            if (middle == null) {
                return null;
            }
            if (middle.data == target) {
                return  middle;
            }
            if (middle.data > target) {
                end = middle;
            }
            if (middle.data < target) {
                start = middle;
            }
        }
        return null;
    }
    private Node getMiddleNode(Node start,Node end){
        if (start == null) {
            return null;
        }
        Node slow = start;
        Node fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
