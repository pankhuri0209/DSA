package leetcode;

import java.util.Arrays;

public class dominantIndex {
    public static int dominantIndex(int[] nums) {

        int res=-1;
        int max=0;

        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                res=i;
                max= nums[i];
            }
        }
        boolean flag=true;
        for(int i=0;i<nums.length;i++)
        {
            if(max<(2*nums[i]))
            {
                flag=false;
            }
        }
        if(flag==true)
        {
            return res;
        }
        return -1;

    }
    public static void main(String[] args)
    {
        // int [] arr= new int[]{44,22,55,11,66};
        //   int[] arr= new int[]{3,2,3,4};
        int[] arr= new int[]{3,6,1,0};
        int res=dominantIndex(arr);

        System.out.println((res));
    }
}
