package striver.bst;

import sun.reflect.generics.tree.Tree;
public class findPreSuc {
    public static void findPredSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==key)
        {
            if(root.left!=null)
            {
                pre[0] = findPred(root.left);
            }
            if (root.right!=null)
            {
                suc[0] = findSuc(root.right);
            }
            return;
        }
        else if(root.val< key)
        {
            pre[0]= root;
            findPredSuc(root.right, pre, suc, key);
        }
        else {
            suc[0] = root;
            findPredSuc(root.left, pre, suc, key);
        }
    }
    private  static TreeNode findPred(TreeNode root)
    {
        while(root.right!=null)
        {
            root= root.right;
        }
        return root;
    }
    private static TreeNode findSuc(TreeNode root)
    {
        while (root.left!=null)
        {
            root= root.left;
        }
        return root;
    }
}
