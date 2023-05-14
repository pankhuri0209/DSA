package bitsManipulation.spf;

import java.util.ArrayList;
import java.util.List;

public class spf {

    static void spf(int n)
    {
        int[] spf= new int[100];
        for(int i=2;i<=n;i++)
        {
            spf[i]=i;
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=i*i;j<=n;j+=i)
            {
                if(spf[j]==j)
                {
                    spf[j]=i;
                }
            }
        }
        while(n!=1)
        {
            System.out.print(spf[n] +" ");
            n=n/spf[n];
        }

    }

    static List<Integer> findPrimeFactors(int n) {
        // code here
        int[] spf= new int[n+1];
        for(int i=2;i<=n;i++)
        {
            spf[i]=i;
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=i*i;j<=n;j+=i)
            {
                if(spf[j]==j)
                {
                    spf[j]=i;
                }
            }
        }
        //  findPrimeFactors();
        ArrayList<Integer> arrlist= new ArrayList<>();
        while(n!=1)
        {
            arrlist.add(spf[n]);
            //System.out.print(spf[n] +" ");
            n=n/spf[n];
        }
        return arrlist;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
       // spf(20);
        findPrimeFactors(20);
    }
}
