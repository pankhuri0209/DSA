package stripe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class partitionLaels {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            map[c - 'a']=i;
        }
        int start = 0, end=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= s.length(); i++) {
            char c=  s.charAt(i);
            end= Math.max(end, map[c - 'a']);
            if (end == i) {
                list.add(end-start+1);
                start=i+1;
            }
        }
        return list;
    }
}
