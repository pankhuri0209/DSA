package striver.bst;

import java.util.ArrayList;
import java.util.List;
// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class inorderMorris {
    public List<Integer> getInorder(TreeNode root)
    {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur= root;
        while(cur!=null)
        {
            //if the current node left left child is null
            if(cur.left==null) {
                inorder.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode prev= cur.left;
                while(prev.right!=null && prev.right!=cur)
                {
                    prev=prev.right;
                }
                if(prev.right ==null)
                {
                    prev.right = cur;
                    cur= cur.left;
                }
                else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return inorder;

    }
}
