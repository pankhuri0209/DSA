package striver.bst;

public class largestBSTSubtreeHelper {

    private int maxSum=0;

    public int maxSumBST(TreeNode root)
    {
        postOrder(root);
        return maxSum;
    }
    private int[] postOrder(TreeNode root)
    {
        if(root==null)
        {
            return new int[]{1,Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left= postOrder(root.left);
        int[] right= postOrder(root.right);

        if(left[0]==1 && right[0]==1 && root.val >left[2] && root.val< right[1])
        {
            int sum= root.val+left[3] + right[3];
            maxSum = Math.max(maxSum, sum);
            int minVal= root.left!=null ? left[1] : root.val;
            int maxVal = root.right!=null ? right[2] : root.val;
            return new int[] {1, minVal, maxVal, sum};
        }
        else {
            return new int[]{0,0,0,0};
        }
    }
}
