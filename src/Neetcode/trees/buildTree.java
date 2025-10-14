package Neetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class buildTree {

    private int prevIndex=0;
    private Map<Integer,Integer> inOrderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //build map for quick of inorder indices
        inOrderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inOrderMap.put(inorder[i],i);
        preorderIndex=0;
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd){
        // base case: no elements to build the tree
        if(inStart>inEnd) return null;

        int rootValue=preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        //if this root has no children , return
        if (inStart == inEnd) {
            return root;
        }
        //find the index of root in inorder to split the left and right subtrees
        int inorderIndex =  inOrderMap.get(rootValue);

        // build the left subtree (elements before the root in order)
        root.left = buildTreeHelper(preorder, inStart, inorderIndex-1);

        // build the right subtree (elements after the root in order)
        root.right = buildTreeHelper(preorder, inorderIndex+1, inEnd);
        return root;

    }
}
