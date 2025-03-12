public class OddEvenLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.print();
        ll.OddEvenLinkedList();
        ll.print();

    }
}
class LinkedList {
    static Node head;
    static Node tail;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void addfirst(int data){
        //step 1: create node
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }

        //step 2: newNode next = head
        newNode.next = head;

        // step 3: make new head
        head = newNode;

    }
    public void addlast(int data) {
        //step 1: create node
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        //step 2: make new tail
        tail.next = newNode;
        tail = newNode;
    }
    void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }System.out.println();
    }
    void OddEvenLinkedList(){
        if (head == null) {
            return;
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }

        if (evenHead == null) {
            head = oddHead;
        } else {
            evenTail.next = oddHead;
            head = evenHead;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }
        
    }
}
