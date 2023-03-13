package Recursion.subsetsum;
import java.io.*;
import java.util.*;
//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ds= new ArrayList<>();
        ssh(0,0,arr,N,ds);
        Collections.sort(ds);
        return ds;

    }
    void ssh(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ds)
    {
        if(ind == N)
        {
            ds.add(sum);
            return;
        }
        ssh(ind+1,sum+arr.get(ind),arr,N,ds); //pick the element
        ssh(ind+1,sum,arr,N,ds);        //not pick the element

    }

}