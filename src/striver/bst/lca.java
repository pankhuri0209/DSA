package striver.bst;

import sun.reflect.generics.tree.Tree;

public class lca {

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q)
    {
        //base case
        if(root ==null || root==p || root==q)
        {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p,q );

        if(left==null)
        {
            return right;
        } else if (right ==null) {
            return left;

        }
        else {
            return root;
        }
    }
}
