import java.util.Arrays;

public class largestSubarray {
    public static void main(String[] args) {
        long[] arr1 = new long[]{-4,-2,1,-3};
        int[] nums= new int[]{1,2,3,4,5};
        int[] arr = new int[]{1 ,2 ,1};
        long ans = maxSumWithK(arr1,arr1.length,2);
        System.out.println(ans);
//        int chunk = 2; // chunk size to divide
//        for(int i=0;i<arr1.length;i+=chunk){
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(nums.length,i+chunk))));
//        }
    }
    public static long maxSumWithK(long a[], long n, long k)
    {
        Arrays.sort(a);
        long new_sum=0;
        int sum=0,c=1;
        for(int i=(int)n-1;i>=0;i--)
        {
            sum+=a[i];
            if(c<=k){
              //  new_sum= Math.max(new_sum,sum);
                new_sum=sum;
            }
            if(sum>new_sum && c>k)
            {
                new_sum= Math.max(new_sum,sum);
            }

            c++;
        }
        return (long)new_sum;
    }
}
