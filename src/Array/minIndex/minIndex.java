package Array.minIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class minIndex {
    public static String[] findRestaurant(String[] list1, String[] list2) {

        ArrayList<String> li= new ArrayList<>();
        int n1= list1.length;
        int n2= list2.length;
        HashMap<String, Integer> map= new HashMap<>();
//        if(n1>=n2)
//        {
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

      //  }
//        else
//        {
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

       // }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(2)) {
                li.add(entry.getKey());
                // System.out.println(entry.getKey());
            }
        }
        String[] stringArray = li.toArray(new String[0]);
        return stringArray;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{1,2,3,4,5,6,7,8,9};
        // String[] B= new String[]{"story","fleet","leetcode"};
        String[] a= new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] b= new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
