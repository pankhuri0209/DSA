public class maxProduct {

    public static void main(String[] args)
    {
        int[] arr= new int[]{6, -3, -10, 0, 2};
       // long ans= maxProduct(arr,arr.length);
        long ans= maxProduct_1(arr,arr.length);
        System.out.println(ans);
    }

     static long maxProduct(int[] a, int n) {
        long p=1;
        Long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {                               //traverse to right
            p=p*a[i];
            max=Math.max(p,max);
            if(p==0)p=1;
        }
        p=1;
        for(int i=n-1;i>=0;i--)
        {  p=p*a[i];
            max=Math.max(p,max);
            if(p==0)p=1;
        }

        return max;
    }
    static long maxProduct_1(int[] arr, int n) {
        long max_ending_here = arr[0];
        long max_so_far = arr[0];
        long min_ending_here = arr[0];

        for (int i = 1; i < n; i++) {
            long temp = Math.max(
                    Math.max(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);

            min_ending_here = Math.min(
                    Math.min(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);

            max_ending_here = temp;

            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
