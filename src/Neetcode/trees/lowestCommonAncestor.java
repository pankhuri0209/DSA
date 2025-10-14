package Neetcode.trees;

public class lowestCommonAncestor {
    //solution 1: iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=root;
        while (curr!=null)
        {
            //both p and q are smaller and lca is the left
            if (p.val< curr.val && q.val<curr.val)
            {
                curr=curr.left;
            }
            else if(p.val> curr.val && q.val>curr.val)
            {
                curr=curr.right;
            }
            else {
                return curr;
            }
        }
        return null;
    }
    // solution 2: recursive
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root==null){return null;}

        //both nodes to the left subtree
        if (p.val< root.val && q.val<root.val)
        {
            lowestCommonAncestor(root.left,p,q);
        } else if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right,p,q);
        }
        return root;

        //both nodes to the right subtree

    }
}
