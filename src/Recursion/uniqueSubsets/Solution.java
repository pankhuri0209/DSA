package Recursion.uniqueSubsets;
import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        int target = 7;

        ArrayList<ArrayList<Integer>> ls = printUniqueSubsets(arr);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {

        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
        findsubsets(0, nums, new ArrayList<>(), arrList);
        return arrList;

    }

    public static void findsubsets(int ind, int[] nums, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> arrList) {
        arrList.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            ds.add(nums[i]);
            findsubsets(i + 1, nums, ds, arrList);
            ds.remove(ds.size() - 1);
        }
    }
}