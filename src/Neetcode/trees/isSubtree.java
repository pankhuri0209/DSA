package Neetcode.trees;

public class isSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //base cases
        if(subRoot==null) return true;
        if(root==null) return false;

        //check the 3 conditions
        //1. current tree matches subtree
        //2. subroot is in the left subtree
        //3. subroot is the right subtree
        return isSameTree(root, subRoot)
                || isSubtree(root.left,subRoot)
                || isSubtree(root.right, subRoot);
    }
    // helper function to check if 2 trees are identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // both null- identical
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return p.val ==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
