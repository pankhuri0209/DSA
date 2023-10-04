package sorting;

import java.util.Arrays;

public class mergeSort {

    public static void divide(int [] arr, int si, int ei)
    {
        if(si>=ei)
        {
            return;
        }
        int mid= si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int [] arr, int si, int mid, int ei)
    {
        int x=0;
        int [] merged = new int[ei-si+1];
        int x1= si;
        int x2= mid+1;
        while(x1 <=mid  && x2<=ei)
        {
            if(arr[x1]<= arr[x2])
            {
                merged[x++]= arr[x1++];
            }
            else {
                merged[x++]= arr[x2++];
            }
        }

        while(x1 <=mid)
        {
            merged[x++]= arr[x1++];
        }

        while(x2 <=ei)
        {
            merged[x++]= arr[x2++];
        }

        for(int i=0, j=si;i< merged.length;i++,j++)
        {
            arr[j]= merged[i];
        }
    }



    public static void main(String[] args)
    {
      //  int arr=new int[] {6,3,9,5,2,8};

        int [] arr= {6,3,9,5,2,8};
        int si= 0;
        int ei= arr.length-1;
        divide(arr,si,ei);

        System.out.println(Arrays.toString(arr));
    }

}
