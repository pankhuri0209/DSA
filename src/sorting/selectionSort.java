package sorting;

import java.util.Arrays;

public class selectionSort {

    public static void Sort(int arr[], int n)
    {
        //code here
      for(int i=0;i<n;i++)
      {
          int min_idx= select(arr,n, i);
          int temp=  arr[min_idx];
          arr[min_idx] =arr[i];
          arr[i]= temp;
      }

    }
    public static int select(int[] arr, int n, int i)
    {
        int min_idx= i;
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
               // int temp= j;
                min_idx= j;

            }
        }
        return  min_idx;

    }

    public static void main(String[] args)
    {
        int [] arr= new int[]{44,22,55,11,66};
        Sort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
