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
    public boolean isNStraightHand1(int[] hand, int groupSize) {
        int n= hand.length;
        if (n%groupSize!=0){
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x:hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int key:map.keySet()){
            int freq= map.get(key);
            if (freq>0)
            {
                for(int i= 0;i<groupSize;i++){
                    int next= key+i;
                    if (map.getOrDefault(next,0)<freq){return  false;}
                    map.put(next, map.get(next)-freq);
                }
            }
        }
        return true;
    }
}
