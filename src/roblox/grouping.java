package roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grouping {
    public List<List<Integer>> groupThePeople(int[] groupSizes)
    {
        Map<Integer, List<Integer>> map= new HashMap<>();
        List<List<Integer>> res= new ArrayList<>();

        for (int i=0;i< groupSizes.length;i++)
        {
            int person=i;
            int groupSize= groupSizes[i];

            List<Integer> group= map.getOrDefault(groupSize, new ArrayList<>());
            group.add(person);
            map.put(groupSize, group);

            if (group.size() == groupSize)
            {
                res.add(group);
                map.remove(groupSize);
            }
        }
        return res;

    }
}
