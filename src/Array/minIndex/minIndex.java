package Array.minIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class minIndex {
    public String[] findRestaurant(String[] list1, String[] list2) {

        ArrayList<String> li= new ArrayList<>();
        int n1= list1.length;
        int n2= list2.length;
        HashMap<String, Integer> map= new HashMap<>();
        if(n1>n2)
        {
            for(int i=0;i<n1;i++)
            {
                if(map.containsKey(list1[i]))
                {
                    map.put(list1[i],map.get(list1[i])+1);
                }
                else
                {
                    map.put(list1[i],1);
                }
            }

        }
        else
        {
            for(int i=0;i<n2;i++)
            {
                if(map.containsKey(list2[i]))
                {
                    map.put(list2[i],map.get(list2[i])+1);
                }
                else
                {
                    map.put(list2[i],1);
                }
            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(2)) {
                li.add(entry.getKey());
                // System.out.println(entry.getKey());
            }
        }
        String[] stringArray = li.toArray(new String[0]);
        return stringArray;
    }
}
