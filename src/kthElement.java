public class kthElement {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 6, 7, 9};
        int[] arr2 = new int[]{1, 4, 8, 10};
        // long ans= maxProduct(arr,arr.length);
        long ans = kthElement(arr1, arr2, arr1.length,arr2.length,5 );
        System.out.println(ans);
    }
    public static long kthElement( int arr1[], int arr2[], int n, int m, int t) {

        int[] res= new int[n+m];
        int i=0,j=0,k=0;
         while(i<=n-1 && j<=m-1)
         {
             if(arr1[i]<arr2[j])
             {
                 res[k]= arr1[i];
                 i++;k++;
             }
             else
             {
                 res[k]= arr2[j];
                 j++;k++;
             }

         }
         while(i<=n-1)
         {
             res[k]= arr1[i];
             i++;k++;
         }
         while(j<=m-1)
         {
             res[k]= arr2[j];
             j++;k++;
         }
        int low=0,high= k;
        int mid=0;
        // for(int s=0;s<k;s++)

        // {
        //  System.out.print(res[s]+" ");
        // }
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(mid==t-1)
            {
                return res[mid];
            }
            if(res[mid]>t)
            {
                high=mid-1;
            }
            else if(res[mid]<t)
            {
                low=mid+1;
            }
            //  else{

            //  }
        }
        return (long)mid+1;
    }
}
