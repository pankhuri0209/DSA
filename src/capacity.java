import java.util.Arrays;

public class capacity {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1 ,2 ,5 ,9};
        int[] nums= new int[]{1,2,3,4,5};
        int[] arr = new int[]{1 ,2 ,1};
        int ans = leastWeightCapacity(arr,3,2);
        System.out.println(ans);
//        int chunk = 2; // chunk size to divide
//        for(int i=0;i<arr1.length;i+=chunk){
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, Math.min(nums.length,i+chunk))));
//        }
    }


    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        int res=-1;
        int low=Integer.MAX_VALUE;
        int high= 0;
        for(int i=0;i<arr.length;i++)
        {
            high+=arr[i];
            low= Math.min(low,arr[i]);
        }

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(arr,mid,D))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    static boolean isPossible(int[] arr, int mid, int D)
    {
        if(arr.length>D)
        {
            return false;
        }
        int ad=1;
        int w=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]+w>mid)
            {
                ad++;
                w= arr[i];

            }
            else
            {
                w+=arr[i];
            }
        }
        if(ad>D)
        {return false;}
        return true;
    }
}
