package StackDataStructure;

public class StackDS2 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);


    }
}
class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Stack {
public static Node head;
public static Node tail;
private static int size = 0;

    public boolean isEmpty(){
        return head == null;
    }
    public void push(int data){
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
    public int pop(){
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
    public int peak(){
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }
}