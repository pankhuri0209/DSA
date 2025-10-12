package Neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class invertTrees {

     // Definition for a binary tree node.


        // Solution 1: Recursive
        public TreeNode invertTree(TreeNode root) {
        //base case
            if (root == null) return null;

            //Swap children
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //recursively invert left and right sub trees
            invertTree(root.left);
            invertTree(root.right);
            return root;

        }
        // Solution 2: Iterative
        public TreeNode invertTree1(TreeNode root) {
          if (root == null) return null;
          Queue<TreeNode> queue = new LinkedList<TreeNode>();
          queue.offer(root);
          while (!queue.isEmpty()) {
              TreeNode curr = queue.poll();
              // swap children
              TreeNode temp = curr.left;
              curr.left = curr.right;
              curr.right = temp;
              //add children to the queue, if they exist
              if (curr.left != null) queue.offer(curr.left);
              if (curr.right != null) queue.offer(curr.right);
          }
          return root;
        }


}
