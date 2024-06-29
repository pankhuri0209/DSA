package Recursion.subsetsum;
import java.io.*;
import java.util.*;
//User function Template for Java//User function Template for Java
class Solution{
   static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ds= new ArrayList<>();
        ssh(0,0,arr,N,ds);
        Collections.sort(ds);
        return ds;

    }
    static void ssh(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ds)
    {
        if(ind == N)
        {
            ds.add(sum);
            return;
        }
        ssh(ind+1,sum+arr.get(ind),arr,N,ds); //pick the element
        ssh(ind+1,sum,arr,N,ds);        //not pick the element

    }
    public static void main(String args[]) {


        ArrayList < Integer > arr = new ArrayList < > ();
        arr.add(2);
        arr.add(3);
      //  arr.add(2);
        ArrayList < Integer > ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }

}