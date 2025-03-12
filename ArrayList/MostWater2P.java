package ArrayList;

import java.util.ArrayList;

public class MostWater2P {
    public static void MostWaterFn(ArrayList<Integer> list){
        int mostwater = 0;
        int lp = 0, rp = list.size() -1;
        while (lp < rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            int currentwater = width * height;
            mostwater = Math.max(mostwater, currentwater);
        
            if (list.get(lp) < list.get(rp)) {
                lp++;
            }else{
                rp--;
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