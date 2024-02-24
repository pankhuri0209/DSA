package Array.minIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class minIndex {
    public static String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map1= new HashMap<>();
        for(int i=0;i<list1.length;i++)
        {
            map1.put(list1[i],i);
        }
        HashMap<String, Integer> map2= new HashMap<>();
        for(int i=0;i<list2.length;i++)
        {
            map2.put(list2[i],i);
        }
        HashMap<String, Integer> map3= new HashMap<>();

        if(map1.size()> map2.size()) {
            for (String key : map1.keySet()) {
                // If the second hashmap contains the same key, add their values
                if (map2.containsKey(key)) {
                    int valueFromMap1 = map1.get(key);
                    int valueFromMap2 = map2.get(key);
                    int sum = valueFromMap1 + valueFromMap2;
                    map3.put(key, sum);
                }
            }
        }
        else
        {

                for (String key : map2.keySet()) {
                    // If the second hashmap contains the same key, add their values
                    if (map1.containsKey(key)) {
                        int valueFromMap1 = map1.get(key);
                        int valueFromMap2 = map2.get(key);
                        int sum = valueFromMap1 + valueFromMap2;
                        map3.put(key, sum);
                    }
                }

        }

        Map.Entry<String,Integer> entry11= map3.entrySet().stream().findFirst().get();
        String key11= entry11.getKey();
        Integer value11= entry11.getValue();
        int j=0;
        int min=  Integer.MAX_VALUE;
        String minKey=null;
        int p=0;
        ArrayList<String> ll= new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            if (p>0 && entry.getValue() <= value11) {
                value11 = entry.getValue();
                minKey = entry.getKey();
                ll.add(minKey);
                //result[j]= minKey;
                j++;
            }
            else if(p==0&&entry.getValue() > value11)
            {
                value11 = entry.getValue();
                minKey = entry.getKey();
                ll.add(minKey);
                //result[j]= minKey;
                j++;
            }
            else
            {
                if(p==0 && map3.size()==1)
                {
                    value11 = entry.getValue();
                    minKey = entry.getKey();
                    ll.add(minKey);
                    j++;
                }
            }
            p++;
        }

        String[] result= ll.toArray(new String[ll.size()]);

        return result;

    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{1,2,3,4,5,6,7,8,9};
        // String[] B= new String[]{"story","fleet","leetcode"};
        String[] a= new String[]{"k","KFC"};
        String[] b= new String[]{"k","KFC"};
        findRestaurant(a,b);
      //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
