import java.util.Arrays;

public class smallestDivisor {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1 ,2 ,5 ,9};
        int[] nums= new int[]{1,2,3,4,5};
//        int ans = smallestDivisor(arr1,6 );
//        System.out.println(ans);
        int chunk = 2; // chunk size to divide
        for(int i=0;i<arr1.length;i+=chunk){
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(nums.length,i+chunk))));
        }
    }

    public static int smallestDivisor(int[] nums, int K) {


        int low=1;
        int high= Integer.MIN_VALUE;
        int ans=0;
        for(int i:nums)
        {
            high= Math.max(i,high);
        }

        while(low<=high)
        {
            int div= low+(high-low)/2;
            if(isPossible(nums,K,div))
            {
                ans=div;
                high=div-1;
            }
            else
            {
                low=div+1;
            }
        }
        return ans;

    }
    public static boolean isPossible(int[] nums, int K, int div)
    {
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=Math.ceil(nums[i]*1.0/K);
        }
        return sum<=K;
    }
}
