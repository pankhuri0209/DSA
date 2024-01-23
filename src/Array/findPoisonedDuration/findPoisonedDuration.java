package Array.findPoisonedDuration;

public class findPoisonedDuration {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int len= timeSeries[timeSeries.length-1] + duration;
        int[] nums= new int[len];
        // int i=0;
        int res=0;
        for(int i=0;i<timeSeries.length;i++)
        {
            if(duration>0)
            {
                nums[timeSeries[i]]=1;

                for(int j=0;j<duration;j++)
                {
                    // if(nums[j]==1)
                    nums[timeSeries[i]+j]=1;
                }

            }


            // i++;
        }
        for(int i=0;i<len;i++)
        {
            if(nums[i]==1)
            {
                res+=1;
            }
        }

        return res;
    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{1,2,3,4,5,6,7,8,9};
        // String[] B= new String[]{"story","fleet","leetcode"};

        System.out.println(findPoisonedDuration(A,0));

        //  System.out.println(res);
    }
}
