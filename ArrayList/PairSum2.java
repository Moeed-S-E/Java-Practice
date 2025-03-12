package ArrayList;

import java.util.ArrayList;

public class PairSum2 {
    public static boolean PairSum2fn(ArrayList<Integer> list,int target){
        int brackingpoint = -1;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i+1)) {
                brackingpoint = i;
                break;
            }
        }
        int lp = brackingpoint+1;
        int rp = brackingpoint;
        while (lp != rp) {
            if (list.get(lp)+list.get(rp) == target) {
                return true;
            }
            if (list.get(lp)+list.get(rp) < target) {
                lp = (lp+1)%n;
            }else{
                rp = (n + rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);


        System.out.println(PairSum2fn(list, 16));



    }
}
