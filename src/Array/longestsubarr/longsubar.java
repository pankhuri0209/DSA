package Array.longestsubarr;

import java.util.HashMap;

public class longsubar {
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function

        int ans=0;
        int sum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<N;i++)
        {
            sum+=A[i];
            if(sum==K)
            {
                ans=i+1;
            }
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }
            if(map.containsKey(sum-K))
            {
                ans=Math.max(ans,i- map.get(sum-K));
            }


        }
        return ans;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{10, 5, 2, 7, 1, 9};
        lenOfLongSubarr(arr,arr.length,15);
    }
}
