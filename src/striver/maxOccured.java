package striver;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class maxOccured {
    public static int maxOccured(int L[], int R[], int n){

        LinkedHashMap<Integer,Integer> map= new LinkedHashMap<>();
        // int len= L.length;
        // int j=0;
        for(int i=0;i<n;i++)
        {
            fillMap(map,L[i],R[i]);
            //j++;

        }
        int res= Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if( res> entry.getKey() && map.get(res)< entry.getValue() &&  map.get(res)!=entry.getValue() )
            {
                res= entry.getKey();
            }
        }
        return res;


    }
    public static void fillMap(LinkedHashMap<Integer,Integer> map, int start, int end){

        for(int i=start;i<=end;i++)
        {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else
            {
                map.put(i,1);
            }
        }
    }
//    public static void main(String[] args)
//    {
//        int[] L= {2,5,3,4,3,3,2,7,9,6};
//        int[] R={4,5,6,7,8,3,10,10,10,10};
//        int res =maxOccured(L,R,L.length);
//        System.out.println(res);
//    }

    static int MAX = 1000000;

    // Return the maximum occurred element in all ranges.
    static int maximumOccurredElement(int[] L, int[] R,
                                      int n)
    {
        // Initialising all element of array to 0.
        int[] arr = new int[MAX];

        // Adding +1 at Li index and
        // subtracting 1 at Ri index.
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
            if (R[i] > maxi) {
                maxi = R[i];
            }
        }
        // Finding prefix sum and index
        // having maximum prefix sum.
        int msum = arr[0];
        int ind = 0;
        for (int i = 1; i < maxi + 1; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                ind = i;
            }
        }
        return ind;
    }

    // Driver program
    static public void main(String[] args)
    {
//        int[] L = { 1, 4, 9, 13, 21 };
//        int[] R = { 15, 8, 12, 20, 30 };
        int[] L = { 1, 2,3 };
        int[] R = { 3,5,7 };
        int n = L.length;
        System.out.println(maximumOccurredElement(L, R, n));
    }
}
