import java.util.ArrayList;
import java.util.Collections;
public class ArrayLists {
    public static void main(String[] args) {
        // size i variable not constant
        //only non-primitive data types like Objects
        // Store in Heap Memory
        //1. add, 2. get, 3. modify, 4. delete/remove, 5. iterate

        // |Integer|Boolean|String|Float|Double| etc
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        // ArrayList<String> list1 = new ArrayList<String>();
        // ArrayList<Boolean> list2 = new ArrayLists<Boolean>();
    
        //Add Element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    
        // Add Element between
        list.add(0,-1);
    System.out.println(list);
        //Get Element
        int element = list.get(2);
        
        System.out.println(element);
        System.out.println(list);
        // Set Element
        list.set(0, 6);
        System.out.println(list);

        //Remove / Delete
        list.removeLast();
        System.out.println(list);

        //Size
        int size = list.size();
        System.out.println(size);

        //Iterate
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // Sorting 
         Collections.sort(list);
        
         System.out.println(list);

    }
}