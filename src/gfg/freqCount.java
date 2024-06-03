package gfg;

import java.util.Arrays;

public class freqCount {
    public static void frequencyCount(int arr[], int N, int P)
    {
        int[] res= new int[N];
        for(int i=0;i<N;i++)
        {
            if(N>=arr[i] )
            {
                res[arr[i]-1]++;
            }
        }
        for(int i=0;i<N;i++)
        {
            arr[i]= res[i];

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args)
    {
        int[] L = {2 ,3 ,2, 3, 5 };
        int N=5,P=5;
        frequencyCount(L,N,P);
       // System.out.println(frequencyCount(L,N,P ));
    }
}
