package Array.containsDuplicate2;

import java.util.HashMap;

public class containsDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        int j=0;
        for(Integer key: map.keySet())
        {
            if(j>=nums.length-1)
            {
                break;
            }
            if(key == nums[j])
            {
                if(Math.abs(map.get(key) - j) <=k)
                {
                    return true;
                }
            }
            j++;
        }
        return false;

    }
    public static void main(String[] args)
    {
        int [] A= new int[]{1,0,1,1};
       // String[] B= new String[]{"story","fleet","leetcode"};

        System.out.println(containsNearbyDuplicate(A,2));

        //  System.out.println(res);
    }
}
