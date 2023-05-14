package Array.moveall0;

public class move {
    static void pushZerosToEnd(int[] arr, int n) {
        // code here

        int a[]= new int[n];
        int j=0,k=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                j++;
            }
            else
            {
                a[k++]= arr[i];
                // System.out.println(a[i]);
            }
        }
        // System.out.println(n-j);
        for(int i=n-j;i<n;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            arr[i]= a[i];
        }
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,0,0,4,4,4};
        pushZerosToEnd(arr,arr.length);
    }
}
