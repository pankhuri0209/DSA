package stacksqueues.maxsub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class maxsub {
    public static void main(String[] args) {
        //    int[] arr = new int[]{3,2,5,6,2,3};
        int[] arr = new int[]{1, 2 ,3, 1 ,4, 5 ,2 ,3 ,6};
        System.out.println((max_of_subarrays(arr, arr.length,3)));
    }
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<k-1;i++)
            max.add(arr[i]);

        int j=k-1,i=0;
        while(j<n)
        {
            max.add(arr[j]);
            ans.add(max.peek());
            max.remove(arr[i]);
            i++;
            j++;
        }
        return ans;
    }
}
