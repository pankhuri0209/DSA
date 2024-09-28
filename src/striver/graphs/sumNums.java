package striver.graphs;

public class sumNums {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(0,root);
    }
    int dfs(int currSum, TreeNode root) {
        if(root == null) return 0;
        currSum =currSum*10+ root.val;
        if(root.left == null && root.right == null) return currSum;
        return dfs(currSum,root.left)+dfs(currSum,root.right);
    }
}
