package searching;

public class rotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int low=0, high= nums.length-1;
            // int mid= (low+high)/2;
            int res=-1;
            while(low<=high)
            {
                int mid= (low+high)/2;
                if(target == nums[mid])
                {
                    return mid;
                }

                if(nums[low]<=nums[mid])
                {
                    if(nums[low] <=target && nums[mid]>= target)
                    {
                        high= mid-1;
                    }
                    else
                    {
                        low= mid+1;
                    }
                }
                else
                {
                    if(nums[high] >=target && nums[mid]<= target)
                    {
                        low= mid+1;
                    }
                    else
                    {
                        high= mid-1;
                    }
                }
            }
            return res;
        }
    }
}
