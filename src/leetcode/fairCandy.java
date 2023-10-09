package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class fairCandy {

    public static int[] fairCandySwap(int[] A, int[] B)
    {
        int[] result= new int[2];
        int totalA=0, totalB=0;
        Set<Integer> setB = new HashSet<>();

        for(int a:A)
        {
            totalA+=a;
        }
        for(int b:B)
        {
            totalB+=b;
            setB.add(b);
        }
        int delta= (totalB - totalA)/2;

        for(int a:A)
        {
            if(setB.contains(a+delta))
            {
                result[0]= a;
                result[1]= a+delta;
                return result;
            }
        }
        return null;

    }
    public static void main(String[] args)
    {
         int [] A= new int[]{1,2};
           int[] B= new int[]{2,3};
     
        int res[]=fairCandySwap(A,B);

        System.out.println(Arrays.toString(res));
    }
}
