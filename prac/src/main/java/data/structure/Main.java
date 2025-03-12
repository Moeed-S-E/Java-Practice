package data.structure;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.append(10);
        list.append(15);
        list.append(20);
        list.prepend(5);
        
        list.display();
        int target = 15;
        Node result = list.search(target);
        if (result != null) {
            System.out.println("Element " + target + " found in the list.");
        } else {
            System.out.println("Element " + target + " not found in the list.");
        }

    }
}
