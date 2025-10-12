package Neetcode.trees;

public class diameterOfBinaryTree {
    //global variable
    private int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {

        calculateHeight(root);
        return maxDiameter;
    }
    //helper function
    private int calculateHeight(TreeNode root){
        if(root==null) return 0;
        int left=calculateHeight(root.left);
        int right=calculateHeight(root.right);
        int currDiameter= left+right;
        maxDiameter=Math.max(currDiameter,maxDiameter);
        return Math.max(left,right)+1;
    }
}
