package striver.bst;

import sun.reflect.generics.tree.Tree;

public class isEqual {

    public boolean isEqual(TreeNode node1, TreeNode node2)
    {
        if(node1==null && node2==null )
        {
            return true;
        }
        else if(node1==null || node2==null)
        {
            return false;
        }
        if(node1.val !=node2.val)
        {
            return false;
        }
       return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);

        //return true;
    }

}
