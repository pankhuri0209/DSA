package s30.dp;

public class canPartition {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for (int num : nums) {
            totalSum+=num;
        }
        if (totalSum%2!=0)
        {return false;}

        int target= totalSum/2;
        Boolean[][] memo = new Boolean[nums.length][target+1];

        return helper(nums, 0, target, memo);
    }
    private boolean helper(int[] nums, int idx, int remainingSum, Boolean[][] memo) {
        //base case :found exact match
        if (remainingSum==0)
        {return true;}
        //base case: out of bounds
        if (remainingSum<0 || idx>=nums.length)
        {return false;}

        //check memo
        if (memo[idx][remainingSum]!=null)
        {return memo[idx][remainingSum];}

        // decision: include or exclude
        boolean include= helper(nums, idx+1, remainingSum-nums[idx],memo); //include
        boolean exclude= helper(nums, idx+1, remainingSum,memo);

        memo[idx][remainingSum]=include||exclude;
        return memo[idx][remainingSum];
    }
}
