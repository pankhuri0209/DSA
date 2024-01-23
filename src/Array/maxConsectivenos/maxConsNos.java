package Array.maxConsectivenos;

public class maxConsNos {
    public static int findMaxConsecutiveOnes(int[] nums) {

        int max= Integer.MIN_VALUE;
        int res=0;

        for(int i=0;i<nums.length;i++)
        {
           // if((i>0 && nums[i-1]==1 && nums[i]==1) || (i==0 && nums[i]==1) )
            if(nums[i]==1)
            {
                if(i==0 ||(i>0 && nums[i-1]==0))
                {
                    res=0;
                    res+=1;
                }
                else
                {
                    res+=1;

                }
                max= Math.max(res,max);
            }
            else
            {
                res=0;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{1,1,0,1,1,1};
        // String[] B= new String[]{"story","fleet","leetcode"};

        findMaxConsecutiveOnes(A);

        //  System.out.println(res);
    }
}
