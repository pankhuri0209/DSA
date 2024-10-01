package blind75;

public class productExceptSelf {
    public int[] product(int[] nums)
    {
        int[] ans = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++)
        {
            ans[i]= leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = nums.length-1; i >=0; i--)
        {
            ans[i]*= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;


    }

}
