package sorting;

import java.util.Arrays;

public class insertionSort {

    public static void insertionSort(int arr[], int n)
    {
        //code here

        int key=0;
        int j=0;

        for(int i=1;i<n;i++)
        {
            j=i-1;
            key=arr[i];

            while(j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;

            }
            arr[j+1]=key;
        }

    }

    public static void main(String[] args)
    {
        int [] arr= new int[]{44,22,55,11,66};
        insertionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }


}
