package Neetcode.trees;

import java.util.Map;

public class maxPathSum {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;

    }
    private int maxPathSumHelper(TreeNode node){
        // base case
        if(node==null) return 0;

        //get max sum from left and right subtrees
        //use math.max with 0 to ignore nes
        int leftMax= Math.max(0, maxPathSumHelper(node.left));
        int rightMax= Math.max(0, maxPathSumHelper(node.right));
        int currentSum = node.val + leftMax + rightMax;
        maxSum = Math.max(currentSum, maxSum);
        return node.val + Math.max(leftMax, rightMax);
    }
}
