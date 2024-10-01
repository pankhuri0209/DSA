package Array;

public class canJump {
    public boolean canJump(int[] nums)
    {
        int farthestReachable=0;

        for (int i=0;i< nums.length;i++)
        {
            if (i> farthestReachable)
            {
                return false;

            }
            farthestReachable = Math.max(farthestReachable, i+nums[i]);
            if (farthestReachable >= nums.length-1)
            {
                return true;
            }

        }
        return false;
    }
}
