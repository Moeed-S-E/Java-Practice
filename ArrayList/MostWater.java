package ArrayList;

import java.util.ArrayList;

public class MostWater {
    public static void MostWaterFn(ArrayList<Integer> list){
        int mostwater = 0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                int ht = Math.min(list.get(i), list.get(j));
                int width = j - i;
                int currentwater = width * ht;
                mostwater = Math.max(mostwater, currentwater);
            }
        }
        System.out.println(mostwater);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);


        MostWaterFn(list);









        
    }
}
