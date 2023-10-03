package sorting;

import java.util.Arrays;

public class bubbleSort {

    public static void bubbleSort(int arr[], int n)
    {
        //code here

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }

        }


    }

    public static void main(String[] args)
    {
        int [] arr= new int[]{44,22,55,11,66};
        bubbleSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }


}
