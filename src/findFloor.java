public class findFloor {

    public static   void main(String[] args)
    {
        long[] arr= new long[]{1,2,8,10,11,12,19 };
        // long ans= maxProduct(arr,arr.length);
        long ans= findFloor(arr,arr.length,20);
        System.out.println(ans);
    }

    static int findFloor(long arr[], int n, long x)
    {
        int low= 0, high = n-1;
        int ans   = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid]==x)
                return mid;
            if(arr[mid]>x)
                high = mid-1;
            else
            {
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}
