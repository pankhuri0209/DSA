package capitalOne;

import org.graalvm.compiler.replacements.IntrinsicGraphBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKfrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>((a,b) -> b.getValue() -a.getValue());

        for (Map.Entry entry : map.entrySet())
        {
            pq.add(entry);
        }
        int[] output= new int[k];
        for(int i=0;i<k;i++)
        {
            output[i]= pq.poll().getKey();
        }
        return output;

    }
}
