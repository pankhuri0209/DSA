package roblox;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class reorganizeStrings {

    public String reorganizeStrings(String s) {
        //counted the freq for map : step1
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        // create a max heap priority queue based on character freq: step2

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(map.entrySet());

        // build the resulting string as step 3
        StringBuilder res= new StringBuilder();
        Map.Entry<Character, Integer> prev= null;

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curr = maxHeap.poll();

            res.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            if (prev != null && prev.getValue() > 0) {
                maxHeap.add(prev);
            }
            prev = curr;
        }
            if (res.length()!= s.length())
            {
                return "";
            }

        return res.toString();

    }
}
