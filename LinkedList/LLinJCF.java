import java.util.LinkedList;

public class LLinJCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(6);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
    }
}
