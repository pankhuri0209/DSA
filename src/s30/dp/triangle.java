package s30.dp;

import java.util.Arrays;
import java.util.List;

public class triangle {
    //O(n^2)
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
     int n = triangle.size();
     memo = new int[n][n];
     for (int i = 0; i < n; i++) {
         Arrays.fill(memo[i], Integer.MAX_VALUE);
     }
     return helper(triangle,0,0);
    }
    public int helper(List<List<Integer>> triangle, int row, int col)
    {
        if (row==triangle.size()){return 0;}
        if (memo[row][col]!=Integer.MAX_VALUE){
            return memo[row][col];
        }
        int left = helper(triangle,row,col+1);
        int right = helper(triangle,row+1,col+1);
        memo[row][col]=Math.min(left, right) + triangle.get(row).get(col);
        return memo[row][col];
    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return helper(triangle,0,0);
    }
    public int helper1(List<List<Integer>> triangle, int row, int col)
    {
        if (row==triangle.size()){return 0;}
        if (memo[row][col]!=Integer.MAX_VALUE){
            return memo[row][col];
        }
        int left = helper1(triangle,row+1,col);
        int right = helper1(triangle,row+1,col+1);
        memo[row][col] = Math.min(left, right) + triangle.get(row).get(col);
        return memo[row][col];
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                if (j==0)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j)+ triangle.get(i-1).get(0));
                } else if (j==i) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+ triangle.get(i-1).get(j-1));
                }
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j)+ Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, triangle.get(n-1).get(j));
        }
        return result;
    }
}
