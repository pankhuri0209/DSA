package s30.dp;

public class LIS1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[] memo = new Integer[n];
        int maxLen=1;
        for(int i=0; i<n; i++){
            maxLen= Math.max(maxLen, helper(nums, i, memo));
        }
        return maxLen;
    }
    private int helper(int[] nums, int i, Integer[] memo){
        if(memo[i]!=null) return memo[i];
        int maxLen=1;

        for (int j=0;j<i;j++)
        {
            if (nums[j] < nums[i])
            {
                maxLen= Math.max(maxLen, helper(nums, j, memo)+1);
            }
        }
        return  maxLen;

    }
}
