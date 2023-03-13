package Recursion.CombinationSum3;

import java.io.*;
import java.util.*;
class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {

        ArrayList<ArrayList<Integer>> res = new ArrayList();
        combinations(1,K,N,res,new LinkedList());
        return res;
    }
    public static void combinations(int start, int K, int N, ArrayList<ArrayList<Integer>> ans,LinkedList ds)
    {
        if(K<0 || N<0)
        {
            return;
        }
        if(K==0 && N==0)
        {
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i=start;i<=9;i++)
        {
            ds.add(i);
            combinations(i+1,K-1,N-i,ans,ds);
            ds.removeLast();
        }
    }

}