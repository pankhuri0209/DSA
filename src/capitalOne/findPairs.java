package capitalOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findPairs {

    public int findPairs(int[] nums, int k)
    {
        Arrays.sort(nums);
        int result=0;

        for (int i=0;i<nums.length;i++)
        {
            if (i>0 && nums[i]==nums[i-1])
            {continue;}
            for (int j=i+1 ; j< nums.length; j++)
            {
                if(j >i+1 && nums[j]==nums[j-1])
                {continue;}

                if (Math.abs(nums[j]-nums[i]) ==k)
                {
                    result++;
                }
            }
        }
        return result;
    }

    // 2pointers approach

    public int findPairs2(int[] nums, int k)
    {
        Arrays.sort(nums);
        int left=0, right=1;
        int result=0;

        while(left <nums.length && right < nums.length)
        {
            if (left == right || nums[right] -nums[left]<k)
            {
                right++;
            }
            else if (nums[right] - nums[left] > k)
            {
                left++;
            }
            else {
                left++;
                result++;
            }

            while (left< nums.length && nums[left] ==nums[left-1])
            {
                left++;
            }
        }
        return result;
    }

    //hashmap

    public int findPairs3(int[] nums, int  k)
    {
        int result=0;
        HashMap<Integer, Integer> counter =new HashMap<>();
        for (int n: nums)
        {
            counter.put(n,counter.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: counter.entrySet())
        {
            int x= entry.getKey();;
            int val= entry.getValue();;
            if (k>0 && counter.containsKey(x+k))
            {
                result++;
            } else if (k==0 && val>1) {
                result++;
            }
        }
        return  result;
    }

}
