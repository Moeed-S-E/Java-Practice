package ArrayList;
import java.util.ArrayList;

public class MultiDemin {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(10);
        list1.add(25);
        list1.add(20);
        list1.add(25);

        mainlist.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);

        mainlist.add(list2);

        for (int i = 0; i < mainlist.size(); i++) {
            ArrayList<Integer> curreArrayList = mainlist.get(i);
            for (int j = 0; j < curreArrayList.size(); j++) {
                System.out.print(curreArrayList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainlist);
        

        
    }
}
