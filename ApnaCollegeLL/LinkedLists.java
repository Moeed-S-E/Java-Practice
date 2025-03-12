public class LinkedLists {
    // non-continous
    public class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    private static int size = 0;
    public int size(){
        return size;
    }

    // add first function
    public void addfirst(int data) {
        Node newNode = new Node(data);
        size++;
        // there is no linked list 
        if (head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    // add last function
    public void addlast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
    public void add(int index,int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: "+index + ", Size: "+size);
        }
        if (index == 0) {
            addfirst(data);
            return;
        }
        if (index == size) {
            addlast(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void removefirst() {
        if (size == 0) {
            System.out.println("Empty..");
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
        return;
    }
    public void removelast() {
        if (size == 0) {
            System.out.println("Empty..");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        Node prevNode = head;
        for (int i = 0; i < size-2; i++) {
            prevNode = prevNode.next;
        }
        prevNode.next = null;
        tail = prevNode;
        size--;
        return;
    }
    public void remove(int index){
        if (index == 0) {
            removefirst();
            return;
        }if (index == size-1) {
            removelast();
            return;
        }
        Node prevNode = head;
        for(int i =0;i<index-1;i++){
            prevNode = prevNode.next;
        }
        prevNode.next = prevNode.next.next;
        size--;
        return;
    }
    public void removeNth(int n){
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + size);
        }
        if (n == 0) {
            removefirst();
            return;
        }
        if (n == size - 1) {
            removelast();
            return;
        }

        Node prevNode = head;
        for (int i = 0; i < size - n - 1; i++) {
            prevNode = prevNode.next;
        }
        prevNode.next = prevNode.next.next;
        size--;


        return;
    }
    public void removeByValue(int value) {
        // Remove all occurrences of the value from the linked list
        while (head != null && head.data == value) {
            head = head.next;
            size--;
        }
    
        if (head == null) {
            tail = null;
            return;
        }
    
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next;
                size--;
                if (temp.next == null) {
                    tail = temp;
                }
            } else {
                temp = temp.next;
            }
        }
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }System.out.println();
    }





    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();  
        ll.addfirst(0);
        ll.addlast(5);
        ll.add(1, 1);
        ll.add(1, 4);
        ll.removeByValue(1);
        ll.print();
        
    }
}
