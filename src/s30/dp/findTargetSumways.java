package s30.dp;

public class findTargetSumways {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for (int num : nums) {
            totalSum+=num;
        }

        //edge cases
        if (Math.abs(target) >totalSum){return 0;} //impossible
        if ((target+totalSum)%2!=0){return 0;} //must be even

        int subsetSum=(target+totalSum)/2;
        Integer[][] memo= new Integer[nums.length][subsetSum+1];

        return helper(nums,0, subsetSum, memo);
    }

    public  int helper(int[] nums, int index, int sum, Integer[][] memo){
        //base case: exact sum achieved
        if (sum==0)
        {
            return 1;
        }
        // base case: out of nos or sum becomes negative
        if (index>=nums.length || sum<0)
        {
            return 0;
        }
        if (memo[index][sum]!=null)
        {
            return memo[index][sum];
        }
        int ways=0;

        //Option 1: Include the current number
        ways+= helper(nums, index+1, sum-nums[index],memo);

        //Option 2: Exclude the current number
        ways+= helper(nums, index+1, sum,memo);

        memo[index][sum]=ways;
        return ways;
    }
}
