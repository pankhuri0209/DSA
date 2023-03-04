public class insertk {

    public static   void main(String[] args)
    {
        int[] arr= new int[]{-83 ,-70 ,-36 ,-23 ,-13, 1, 2 ,6 ,10,11 ,13, 14, 15, 17, 18, 19, 23, 24, 31, 34, 42, 44, 46, 47, 48, 51, 57, 59, 60, 62, 63, 65, 72 ,75, 79, 81, 82, 83, 84, 85, 86, 87, 89, 90, 92 ,94, 96, 97, 98};
        // long ans= maxProduct(arr,arr.length);
        int ans= searchInsertK(arr,arr.length,-4);
        System.out.println(ans);
    }
    static int searchInsertK(int Arr[], int N, int k)
    {
        // code here
        int low = 0, high = N-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(k == Arr[mid]) return mid;
            else if (k < Arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    static int search(int arr[], int low, int high, int k)
    {
        int n= arr.length;
        int pos=0;
        while(low<high)
        {
            int mid= low+ (high-low)/2;
            if(arr[mid]==k)
            {
                pos= mid;
                return pos;
            }
            else if(arr[mid]<k)
            {
                low= mid+1;
                pos= low;
            }
            else if(arr[mid]>k)
            {
                high= mid-1;
                pos= high;
            }
        }
        // if(low==n)
        // {
        //     return n;
        // }
        // else if(high==-1)
        // {
        //     return 0;
        // }
        return pos;
    }
}
