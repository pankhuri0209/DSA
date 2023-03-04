public class findkRotation {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 1, 2, 3, 4};
        int[] arr2 = new int[]{1, 4, 8, 10};
        // long ans= maxProduct(arr,arr.length);
        long ans = findKRotation_2(arr1, arr1.length );
        System.out.println(ans);
    }
    public static int findKRotation(int arr[], int n) {

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0;i < n;i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        index++;
        if(index == n) {
            return 0;
        }

        return index;

    }
    public static int findKRotation_1(int arr[], int n) {

        for(int i=n-2;i>=0;i--){
            if(arr[i+1]>arr[i]) continue;
            else  return i+1;
        }
        return 0;}
    public static int findKRotation_2(int arr[], int n) {
        // code here

         int st = 0,end = n-1;

        while(st<end)
        {
            int mid = st + (end - st) /2;

            if(arr[mid] < arr[end])
            {
                end = mid;
            }
            else
            {
                st = mid+1;
            }
        }

        return st;
    }
}
