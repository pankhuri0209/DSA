package bitsManipulation.spf;

import java.util.ArrayList;
import java.util.List;

public class spf2 {

    static void sieve(boolean[] arr,int n)
    {
        for(int i=2;i<=n;i++)
        {
            arr[i]=true;
        }
        for(int i=2;i*i<=n;i++)
        {
            for(int j=2*i;j<=n;j+=i)
            {
                arr[i]= false;
            }
        }
    }
    static List<?> findspf(int n)
    {
        List<Integer> arrlist= new ArrayList<>();
        boolean[] arr= new boolean[n+1];
        sieve(arr,n);

        for(int i=2;i<=n;i++)
        {
            if(arr[i] ==true) {
                while (n%i==0)
                {
                    arrlist.add(i);
                    n=n/i;
                }
            }
        }

        return arrlist;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        findspf(20);
    }
}
