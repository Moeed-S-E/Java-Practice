public class SwapNodes {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.print();

        ll.SwapNodes(2, 4);
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
    void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }System.out.println();
    }
    void SwapNodes(int x,int y){
        if (x == y) return;

        Node prevX = null, currX = head;
        Node prevY = null, currY = head;
        for (int i = 1; currX != null && i < x; i++) {
            prevX = currX;
            currX = currX.next;
        }
        for (int i = 1; currY != null && i < y; i++) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) return;
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }
        
        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
}