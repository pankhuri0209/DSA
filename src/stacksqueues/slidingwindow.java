package stacksqueues;

public class slidingwindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res= new int[nums.length-k+1];
        int j=0,m=k;
        for(int i=0;i<=nums.length-k;i++)
        {
            int max= Integer.MIN_VALUE;
            //   int ind=0;
            if(i+m> nums.length)
            {
                while(m!=0 && i+m> nums.length)
                {
                    max=Math.max(nums[i+m-1], max);
                    m--;
                }
            }
            else
            {
                while(m!=0)
                {
                    max=Math.max(nums[i+m-1], max);
                    m--;
                }
            }
            res[j++]=max;
            m=k;
        }
        return res;
    }
    public static void main(String[] args) {
        // Solution sol = new Solution();
        int[] heights = {1,3,-1,-3,5,3,6,7};
        int[] res= maxSlidingWindow(heights,3);
        //System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
