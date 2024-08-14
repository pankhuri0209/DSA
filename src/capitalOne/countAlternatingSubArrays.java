package capitalOne;

public class countAlternatingSubArrays {
    public long countAlterntaingSubarrys(int[] nums)
    {
        long count=0;
        count+=nums.length;
        int length=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                length++;
            }
            else {
                count = (long) (length)*(length-1)/2;
                length=1;
            }
        }
        count+= (long) (length)*(length-1)/2;

        return count;
    }
}
