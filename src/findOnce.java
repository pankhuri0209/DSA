public class findOnce {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4};
        // long ans= maxProduct(arr,arr.length);
        int ans = findOnce(arr,  arr.length );
        System.out.println(ans);
    }
    public static int findOnce(int arr[], int n)
    {
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(mid-1>=0 && arr[mid]==arr[mid-1]){
                if(mid%2==0){
                    high=mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(mid+1<=high && arr[mid]==arr[mid+1]){
                if(mid%2==0){
                    low = mid+1;

                }
                else{
                    high=mid-1;
                }
            }
            else{
                return arr[mid];
            }


        }
        return -1;
    }
}
