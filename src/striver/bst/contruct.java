package striver.bst;

import java.util.HashMap;
import java.util.Map;

public class contruct {

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        Map<Integer,Integer> inmap= new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            inmap.put(inorder[i],i);
        }
        TreeNode root= buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1,inmap);
        return root;
    }
    public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap)
    {
        if(preStart> preEnd || inStart>inEnd)
        {
            return null;
        }
        TreeNode root= new TreeNode(preOrder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft= inRoot - inStart;;

        root.left = buildTree(preOrder, preStart+1, preStart+numsLeft, inOrder, inStart, inRoot-1, inMap);

        root.right =buildTree(preOrder, preStart+numsLeft+numsLeft+1, preEnd, inOrder, inRoot+1, inEnd, inMap
        );
        return root;
    }
}
