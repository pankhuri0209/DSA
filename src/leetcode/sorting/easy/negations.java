package leetcode.sorting.easy;

import java.util.Arrays;

public class negations {
    public static int largestSumAfterKNegations(int[] nums, int k)
    {
        Arrays.sort(nums);
        // a ngative/positive boundary
        // array length boundary
        // 0 as boundary

        int maxSum=0;

        for(int i=0;i<nums.length;i++)
        {
            if(k>0)
            {
                if(nums[i] >0)
                {
                    if(k%2 ==1)
                    {
                        nums[i] = -nums[i];
                    }
                    k=0;
                }
                else if(nums[i] ==0)
                {
                    k=0;
                }
                else if(nums[i]<0)
                {
                    if(i == nums.length -1)
                    {
                        // {-4,-3,-2,-1}
                        if(k%2==1)
                        {
                            nums[i]=-nums[i];
                        }
                        k=0;
                    }
                    else if(nums[i+1] >0)
                    {
                        // {-4,3}, {-4,6}
                        if(Math.abs(nums[i]) > nums[i+1]) {
                            if (k % 2 == 1) {
                                k = 0;
                            } else {
                                k = 1;
                            }
                            nums[i]=-nums[i];
                        }
                        else {
                            //{-4,-3}
                            if(k%2==1)
                            {nums[i] = -nums[i];}
                            k=0;
                        }
                    }
                    else
                    {
                        nums[i] = -nums[i];
                        k--;
                    }
                }
            }
            maxSum+=nums[i];
        }

        return maxSum;
    }
}
