package striver.bst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class distinctNos {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 1, 3, 4, 3};
        int B1 = 3;
        System.out.println(Arrays.toString(countDistinctNumbersInWindows(A1, B1))); // Output: [2, 3, 3, 2]

        int[] A2 = {1, 1, 2, 2};
        int B2 = 1;
        System.out.println(Arrays.toString(countDistinctNumbersInWindows(A2, B2))); // Output: [1, 1, 1, 1]
    }
    public static int[] countDistinctNumbersInWindows(int[] A, int B) {

        int n = A.length;
        if(B>n)
        {
            return new int[0];
        }
        int [] res= new int[n-B+1];
        Map<Integer, Integer> map =new HashMap<>();

        //initialize map with first window
        for(int i=0;i<B;i++)
        {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }

        res[0] = map.size();

        for(int i=B;i<n;i++)
        {
            int outEle = A[i-B];
            if(map.get(outEle) ==1)
            {
                map.remove(outEle);
            }
            else {
                map.put(outEle, map.get(outEle)-1);
            }
            int inEle = A[i];
            map.put(inEle, map.getOrDefault(inEle,0)+1);

            res[i-B+1] =map.size();
        }
        return res;
    }
}
