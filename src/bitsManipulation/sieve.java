package bitsManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public  class sieve {
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        ArrayList<Integer> arrlist= new ArrayList<>();
        boolean[] arr= new boolean[N+1];
        Arrays.fill(arr,true);
        arr[0]= false;
        arr[1]= false;
        for(int i=2;i*i<=N;i++)
        {
            for(int j=2*i;j<=N;j+=i)
            {
                arr[j]=false;
            }
        }
        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]==true)
            {
                arrlist.add(i);
            }
        }
        //List li= Arrays.asList(arr);
        return arrlist;

    }
    public static void main(String[] args) {

        int[] arr = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        sieveOfEratosthenes(12);
    }
}
