package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class pairElements {
    public static int arrayPairSum(int[] nums) {
        ArrayList<Integer> list= new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            list.add(nums[i]);
        }
        Collections.sort(list);

        int res= 0;
        for(int i=0;i<list.size()-1;i+=2)
        {
            res+= Math.min(list.get(i), list.get(i+1));
        }
        return res;
    }
    public static void main(String[] args)
    {
        // int [] arr= new int[]{44,22,55,11,66};
        int[] arr= new int[]{1,4,3,2};
        int res=arrayPairSum(arr);

        System.out.println(res);
    }
}
