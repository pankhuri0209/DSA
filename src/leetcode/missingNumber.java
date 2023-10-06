package leetcode;

public class missingNumber {
    public int missingNumber(int[] nums) {

        int n= nums.length;

        int sum= n*(n+1)/2;
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            total += nums[i];
        }
        return sum-total;

    }
}
