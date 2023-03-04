public class peakElement {
    public static   void main(String[] args)
    {
        int[] arr= new int[]{1,2,3,5,10,44,33,80};
        // long ans= maxProduct(arr,arr.length);
        int ans= peakElement(arr,arr.length);
        System.out.println(ans);
    }
    public static int peakElement(int[] arr,int n) {
    int low=0;
    int high= n-1;

    while(low<=high)
    {
        int mid= low+(high-low)/2;
        if((mid==0 || arr[mid]>=arr[mid-1]) &&
                (mid==n-1 || arr[mid]>=arr[mid+1]))
        {
            return mid;
        }
        else if(arr[mid] <=arr[mid+1])
        {
            low=mid+1;
        }
        else {
            high= mid-1;
        }

    }

    return -1;
    }
}
