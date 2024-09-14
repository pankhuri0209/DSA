package striver.graphs;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class rightSideView {

    public List<Integer> rightSideView(TreeNode root)
    {

        if(root== null)
        {
            new ArrayList<Integer>();
        }
        ArrayList<Integer> bfs= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n= q.size();
            for (int i=0;i<n;i++)
            {
                TreeNode curr= q.poll();
                if(i==n-1)
                {
                    bfs.add(curr.val);
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if (curr.right!=null)
                {
                    q.add(curr.right);
                }
            }

        }
        return bfs;


    }
}
