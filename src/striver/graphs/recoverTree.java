package striver.graphs;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class recoverTree {

    public void swap(TreeNode a, TreeNode b)
    {
        int temp= a.val;
        a.val= b.val;
        b.val= temp;
    }
    public void recoverTree(TreeNode root)
    {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x=null, y=null, pred=null;

        while(!stack.isEmpty() || root != null)
        {
            while(root != null)
            {
                stack.push(root);
                root= root.left;
            }
            root= stack.removeLast();

            while(pred!=null && pred.val> root.val)
            {
                y=pred;
                if(x==null)
                {
                    x= root;
                }
                else{break;}
            }
            pred= root;
            root= root.right;
        }
        swap(x,y);
    }
}
