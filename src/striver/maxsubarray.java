package striver;

public class maxsubarray {

    //kadane's algo
    public int maxSubArray1(int[] nums) {

        int sum=0, maxi= Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>maxi)
            {
                maxi=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxi;
    }

    public static int maxSubArray(int[] nums) {
        int maxsum=0;

        if(nums.length==1)
        {
            return nums[0];
        }

        for(int i=0;i<nums.length;i++)
        {
            int j= i+1;
            if(i<=nums.length-1)
            {
                int sum= nums[i];
                maxsum= Math.max(maxsum,sum);
                while(j!=nums.length )
                {
                    sum+=nums[j];
                    maxsum= Math.max(maxsum,sum);
                    j++;
                }
            }
        }

        return maxsum;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{-2,-1};
        // String[] B= new String[]{"story","fleet","leetcode"};
//        String[] a= new String[]{"k","KFC"};
//        String[] b= new String[]{"k","KFC"};
        System.out.println(maxSubArray(A));

        //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
