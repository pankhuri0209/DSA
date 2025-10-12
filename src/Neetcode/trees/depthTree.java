package Neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class depthTree {


    public int maxDepth(TreeNode root) {
        //base case: empty tree has 0 depth
        if(root==null) return 0;

        // recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int depth=0;
        while(!q.isEmpty()){
            int size = q.size();

            //process all nodes at current level
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                // add children to the queue
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);

            }
            depth++;
        }
        return depth;
    }
}
