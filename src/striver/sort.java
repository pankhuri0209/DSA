package striver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class sort {
    public static void sortColors(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
                //map.put(nums[i],map.get(nums[i])+1));
            }
            else
            {
                map.put(nums[i],1);
            }
        }

        int index=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int key= entry.getKey();
            int val= entry.getValue();
            for(int i=0;i<val;i++)
            {
                nums[index]=key;
                index++;
            }
        }
        // return nums;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{2,0,2,1,1,0};
        // String[] B= new String[]{"story","fleet","leetcode"};
//        String[] a= new String[]{"k","KFC"};
//        String[] b= new String[]{"k","KFC"};
        sortColors(A);

        for(int i=0;i<A.length;i++)
        {
            System.out.println(A[i]);
        }
        System.out.println();
        //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
