public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    private static int size = 0;
    public int size(){return size;}

    public void addfirst(int data){
        //step 1: create node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }

        //step 2: newNode next = head
        newNode.next = head;

        // step 3: make new head
        head.prev = newNode;
        head = newNode;

    }
    public void addlast(int data) {
        //step 1: create node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        //step 2: make new tail
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    public void add(int index,int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addfirst(data);
            return;
        }else if (index == size) {
            addlast(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i<index-1) {
            temp = temp.next; 
            i++;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }
    public int removefirst(){
        
        if (size == 0) {
            System.out.println("Empty..");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return  val;
        }else{
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }
    }
    public int removelast(){
        if (size == 0) {
            System.out.println("Empty..");
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        if (size == 1) {
            head = tail = null;
            
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }
    public int remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return removefirst();
        }else if (index == size-1) {
            return removelast();
        }
        Node prevNode = head;
        for(int i =0;i<index-1;i++){
            prevNode = prevNode.next;
        }

        int val = prevNode.next.data;
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        size--;
        return val;
    }
    public boolean removeByValue(int data){
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else{
                tail = null;
            }
            size--;
            return true;
        }
        if (tail.data == data) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return true;
        }
        Node prevNode = head;
        while (prevNode.next != null) {
            if (prevNode.next.data == data){
                prevNode.next = prevNode.next.next;
                if (prevNode.next != null) {
                    prevNode.next.prev = prevNode;
                }
                size--;
                return true;
            }
            prevNode = prevNode.next;
        }
        return false;
    }
    public void removeNth(int n){
        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + size);
        }
        if (n == 0) {
            if (size == 1) {
                head = tail = null;
            }else{
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return;
        }
        int indexToRemove = size - n - 1;
        if (indexToRemove == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        
        Node currentNode = head;
        for (int i = 0; i < indexToRemove; i++) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next = currentNode.next;
        if (currentNode.next == null) {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return;
    }
    public int search(int target){
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == target) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return Integer.MIN_VALUE;
    }
    public void reverse(){
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            currentNode.prev = nextNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
        head.prev = null;
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
        return;
    }
    public void traverseForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
        return;
    }
    public void traverseBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
        return;
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addfirst(5);
        dll.addlast(6);
        dll.addlast(7);
        dll.addlast(8);
        dll.addlast(9);
        // dll.removefirst();
        dll.print();
        dll.reverse();
        dll.print();


    }
}
