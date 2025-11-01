package Neetcode.greedy;

import java.util.TreeMap;

public class isnStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n= hand.length;
        if (n%groupSize!=0){
            return false;
        }
        // Count Freq in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x:hand){
            map.merge(x,1,Integer::sum);
        }
        while (!map.isEmpty()){
            int start= map.firstKey();
            int need= map.get(start);

            for (int v= start;v<start+groupSize;v++){
                Integer count= map.get(v);
                if (count==null || count<need){
                    return false;
                }
                if (count==need){
                    map.remove(v);
                }

            }
        }


        return true;
    }
}
