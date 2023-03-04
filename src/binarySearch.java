public class binarySearch {

    public static   void main(String[] args)
    {
        int[] arr= new int[]{1, 2, 3, 4, 5 };
        // long ans= maxProduct(arr,arr.length);
        long ans= binarysearch_1(arr,arr.length,4);
        System.out.println(ans);
    }
    public static int binarysearch_1(int arr[], int n, int k) {
        // code here
        int res= search(arr,0,n,k);
        return res;
    }
    public static int search(int arr[], int start, int end, int k)
    {
        int mid= start+ (end-start)/2;
        if(arr[mid] == k)
        {
            return mid;
        }
        else if(arr[mid]>k)
        {
            return search(arr,0,mid-1,k);
        }
        else
        {
           return search(arr,mid+1,arr.length-1,k);
        }

        //return -1;

    }
}
