package striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public  class maxLenZero {

public static     int maxLen(int arr[], int n)
    //int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int res=0;

        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==0)
            {
                res=i+1;
            }
            else
            {
                if(map.containsKey(sum))
                {
                    res=Math.max(res,i-map.get(sum));
                }
                else
                {
                    map.put(sum,i);
                }
            }
        }
        return res;
    }

    public static int maxLen1(int arr[], int n)
    {
        // Your code here
        Arrays.sort(arr);
        int res=0;
        int maxLen=0;
        for(int i=0;i<n;i++)
        {
            maxLen=0;
            int sum= arr[i];
            for(int j=i+1;j<n;j++)
            {

                sum+=arr[j];
                maxLen++;
                if(sum==0)
                {
                    res= Math.max(maxLen,res);
                }

            }
        }
        return res;

    }
    public static void main(String[] args)
    {
        //  int [] A= new int[]{0,1,2,4,5,7};
        int [] A= new int[]{15, -2, 2 ,-8 ,1, 7, 10, 23};
        // String[] B= new String[]{"story","fleet","leetcode"};
//        String[] a= new String[]{"k","KFC"};
//        String[] b= new String[]{"k","KFC"};
        System.out.println(maxLen1(A, A.length));
        /// lis.stream().forEach(System.out::println);

//        for(int i=0;i<A.length;i++)
//        {
//            System.out.println(A[i]);
//        }

        //  System.out.println(findRestaurant(a,b));

        //  System.out.println(res);
    }
}
