public class LinkedList {
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
        tail = newNode;
    }
    public void add(int index,int data) {
        if (index == 0) {
            addfirst(data);
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
        temp.next = newNode;
    }
    public void display(){
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data+" -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }
    public int size(){
        return size;
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
            size--;
            return val;
        }
    }
    public int removelast(){
        if (size == 0) {
            System.out.println("Empty..");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return  val;
        }

        Node prevNode = head;
        for (int i = 0; i < size -2; i++) {
            prevNode = prevNode.next;
        }
        int val = prevNode.data;
        prevNode.next = null;
        tail = prevNode;
        size--;
        return val;
    }
    public int remove(int index){
        if (index == 0) {
            return removefirst();
        }
        Node prevNode = head;
        for(int i =0;i<index-1;i++){
            prevNode = prevNode.next;
        }

        int val = prevNode.next.data;
        prevNode.next = prevNode.next.next;
        size--;
        return val;
    }
    public boolean removeByValue(int data){
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            return true;
        }
        Node prevNode = head;
        while (prevNode.next != null) {
            if (prevNode.next.data == data){
                prevNode.next = prevNode.next.next;
                return true;
            }
            prevNode = prevNode.next;
        }
        return false;
    }
    public void removeNth(int n){
        int sz = 0;//size
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            sz++;
            if (n == sz) {
                head = head.next;
                return;
            }
        }
        int i = 1;
        int indexToFind = sz - n;
        Node prevNode = head;
        while (i<indexToFind) {
            prevNode = prevNode.next;
            i++;
        }
        size--;
        prevNode.next = prevNode.next.next;
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
    public Node binarySearch(int target){
        Node start = head;
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
    private int helper(Node head,int target){
        if (head == null) {
            return -1;
        }
        if (head.data == target) {
            return 0;
        }
        int index = helper(head.next, target);
        if (index == -1) {
            return -1;
        }
        return index+1;
    }
    public int searchRecursively(int target){
        return helper(head, target);
    }
    public void reverse(){
        Node prevNode = null;
        Node currentNode = tail = head;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head = prevNode;
    }
    public boolean checkPalindrome(){
        if (head == null || head.next == null) {
            return true;
        }
        Node rightNode = head;
        reverse();
        Node leftNode = head;

        while (rightNode != null) {
            if (leftNode.data != rightNode.data) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return true;
    }
    public boolean cycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        boolean cycle = cycle();
        if (cycle == false) {
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
        }
        Node prevNode = null;
        while (slow != fast) {
            prevNode = fast;
            slow = slow.next;
            fast = fast.next;
        }
    
        prevNode.next = null;

    }
    public Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }        
        Node mid = getMiddleNode(head);

        Node rightNode = mid.next;
        mid.next = null;
        Node newLeftNode = mergeSort(head);
        Node newRightNode = mergeSort(rightNode);

        return merge(newLeftNode,newRightNode);
    }
    private Node getMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;  // Corrected: fast starts at head.next
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node leftNode,Node rightNode){
        Node mergedLL = new Node(Integer.MIN_VALUE);
        Node temp = mergedLL;
        while (leftNode != null && rightNode != null) {
            if (leftNode.data <= rightNode.data) {
                temp.next  = leftNode;
                leftNode = leftNode.next;
                temp = temp.next;
            }else{
                temp.next = rightNode;
                rightNode = rightNode.next;
                temp = temp.next;
            }
        }
        while (leftNode != null) {
            temp.next = leftNode;
            leftNode = leftNode.next;
            temp = temp.next;
        }
        while (rightNode != null) {
            temp.next = rightNode;
            rightNode = rightNode.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
    
    public void zigzag() {
        // Base case: If the list is empty or has only one element, there's no need to rearrange
        if (head == null || head.next == null) {
            return;
        }
    
        // Step 1: Find the middle of the list
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow; // Middle node (slow will point here)
    
        // Step 2: Reverse the second half of the list
        Node currentNode = midNode.next;
        Node prevNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        midNode.next = null; // The end of the first half should be disconnected
    
        // The second half is now reversed, starting from 'prevNode'
        Node leftNode = head;
        Node rightNode = prevNode;
    
        // Step 3: Merge the two halves in a zigzag pattern
        Node nextL, nextR;
        while (leftNode != null && rightNode != null) {
            nextL = leftNode.next;
            nextR = rightNode.next;
    
            // First, connect left node to right node
            leftNode.next = rightNode;
            
            // If the left node ends, stop merging
            if (nextL == null) break;
    
            // Then, connect right node to the next left node
            rightNode.next = nextL;
    
            // Move to the next pair of nodes
            leftNode = nextL;
            rightNode = nextR;
        }
    }
    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addfirst(2);
        // ll.addfirst(1);
        // ll.addlast(4);
        // ll.add(2, 3);
        // ll.addlast(6);
        // ll.addlast(6);
        // ll.removeByValue(6);
        // ll.remove(5);
        // ll.removelast();
        // System.out.println(ll.search(4));
        // System.out.println(ll.search(8));
        // int size = ll.size();
        // System.out.println(size);
        
        // ll.display();
        // ll.reverse();
        // System.out.println(ll.checkPalindrome());
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);

        ll.display();
        // ll.zigzag();
        // ll.display();
        head = ll.mergeSort(head);
        ll.display();


    }
}
