public class SolutionQ1 {

    // Inner class for LinkedList
    public static class LinkedList {

        // Inner class for Node
        public static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        // Method to calculate the length of a linked list
        public int length(Node headNode) {
            Node temp = headNode;
            int length = 0;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }

        // Method to find the intersection node of two linked lists
        public Node getIntersectionNode(Node headA, Node headB) {
            if (headA == null || headB == null) {
                return null; // No intersection if either list is empty
            }

            // Step 1: Calculate the lengths of both lists
            int lenA = length(headA);
            int lenB = length(headB);

            // Step 2: Align the starting points
            Node ptrA = headA;
            Node ptrB = headB;

            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; i++) {
                    ptrA = ptrA.next;
                }
            } else {
                for (int i = 0; i < lenB - lenA; i++) {
                    ptrB = ptrB.next;
                }
            }

            // Step 3: Traverse both lists simultaneously
            while (ptrA != null && ptrB != null) {
                if (ptrA == ptrB) {
                    return ptrA; // Intersection found
                }
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }

            return null; // No intersection
        }
    }

    public static void main(String[] args) {
        // Create an instance of the LinkedList class
        LinkedList list = new LinkedList();

        // Create the first linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedList.Node headA = new LinkedList.Node(1);
        headA.next = new LinkedList.Node(2);
        headA.next.next = new LinkedList.Node(3);
        headA.next.next.next = new LinkedList.Node(4);
        headA.next.next.next.next = new LinkedList.Node(5);

        // Create the second linked list: 6 -> 7 -> 4 -> 5
        LinkedList.Node headB = new LinkedList.Node(6);
        headB.next = new LinkedList.Node(7);
        headB.next.next = headA.next.next.next; // Intersection at node with value 4

        // Find the intersection node
        LinkedList.Node intersectionNode = list.getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection Node: " + intersectionNode.data);
        } else {
            System.out.println("No Intersection");
        }
    }
}