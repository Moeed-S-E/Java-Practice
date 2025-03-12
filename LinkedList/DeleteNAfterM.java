public class DeleteNAfterM {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addfirst(10);
        ll.addfirst(9);
        ll.addfirst(8);
        ll.addfirst(7);
        ll.addfirst(6);
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.print();

        ll.deleteNAfterM(5, 4);
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
    void deleteNAfterM(int M,int N){
        Node temp = head;
        int count = 1;
        while (count != M && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp != null) {
        Node prevNode = temp;
        for(int i = 0; i < N;i++){
            if (prevNode.next != null) {
            prevNode.next = prevNode.next.next;
            }else{
                break;
            }
        }
    }
    }
}