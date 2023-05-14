package Array;

public class searchinginsorted {
    static int searchInSorted(int arr[], int N, int K)
    {

        // Your code here
        int res=bs(arr,0,N-1,K);
        return res;
    }
    static int bs(int arr[],int low, int high, int X)
    {

        if(low<=high)
        {

            int size= arr.length;
            int mid = low+(high-low)/2;

            if(arr[mid] == X )
            {
                return 1;
            }

            else if(arr[mid]>X)
            {
                return bs(arr,low,mid-1,X);

            }
            else
            {
                return  bs(arr,mid+1,high,X);
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,0,0,4,4,4};
        searchInSorted(arr,arr.length,6);
    }
}
