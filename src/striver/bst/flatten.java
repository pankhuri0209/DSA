package striver.bst;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class flatten {
    public void flatten(TreeNode root)
    {
        if(root==null)

        {
            return;
        }
        Stack<TreeNode> st= new Stack<>();
        st.push(root);

        while (!st.isEmpty())
        {
            TreeNode cur = st.pop();

            if(cur.right!=null)
            {
                st.push(cur.right);
            }
            if(cur.left!=null)
            {
                st.push(cur.left);
            }
            if(!st.isEmpty())
            {
                cur.right= st.peek();
            }
            cur.left= null;

        }
    }
}
