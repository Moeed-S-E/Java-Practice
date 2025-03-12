package ArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListP1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.addFirst(4);
        list.addLast(5);
        list.add(0, 3);
        list.add(6);
        
        int size = list.size();
        System.out.println(list);
        System.out.println(size);

        for (int i = size-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }System.out.println();
        System.out.println(maxNum(list));
        swap(list, 1, 0);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    public static int maxNum(ArrayList<Integer> list){
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }
    public static void swap(ArrayList<Integer> list,int aidx,int bidx){
        int a = list.get(aidx);
        int b = list.get(bidx);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        list.set(aidx, a);
        list.set(bidx, b);
    }
}
