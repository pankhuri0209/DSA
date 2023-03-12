package Recursion.Combination_sum2;


import java.io.*;
import java.util.*;

  public class CombinationSum2 {
    public static void main(String[] args) throws IOException {

        int arr[] = {1,1,1,2,2};
        int target = 4;
        CombinationSum2 sol = new CombinationSum2();
        List < List < Integer >> ls = Solution.combinationSum2(arr, target);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }

        }
    }

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        findCombinations(0,a,s,ans,new ArrayList<>());
        return ans;
    }
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans,List<Integer> ds)
    {
        if(target ==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++)
        {
            if(i>ind && arr[i] ==arr[i-1]){continue;}
            if(arr[i]>target){break;}
            ds.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }


    }
}