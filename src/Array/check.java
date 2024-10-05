package Array;

import java.util.Arrays;

public class check {
//    public static boolean check(int[] nums) {
//        int j=0, n= nums.length;
//        int[] newA= new int[n];
//        while(j<n)
//        {
//            for(int i=1;i<=n;i++)
//            {
//                newA[i-1] = nums[(n+i+j)%n];
//
//            }
//            if(func(newA, nums))
//            {
//                return true;
//            }
//            j++;
//        }
//        return false;
//    }
//
//    public static boolean func(int[] newA, int[] sorted)
//    {
//        Arrays.sort(sorted);
//        for(int i=0;i< newA.length;i++)
//        {
//            if(newA[i]!= sorted[i])
//            {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean check(int[] nums)
    {
        int countDrops =0;
        int n= nums.length;

        for (int i=0;i<n;i++)
        {
            if (nums[i]> nums[(i+1) %n])
            {
                countDrops++;
            }
            if (countDrops > 1)
            {return false;}
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums= {2,1,3,4};
        System.out.println(check(nums));
    }
}
