package striver.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class maxLevelSum {

    public int maxLevelSum(TreeNode root) {

        if(root==null)
        {
            return -1;
        }
        int maxLevel= 1;
        int currLevel=1;
        int maxSum= Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n= q.size();
            int currLevelSum=0;
            for(int i=0;i<q.size();i++)
            {
                TreeNode curr= q.poll();
                currLevelSum+=curr.val;
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if (curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            if(currLevelSum>maxSum)
            {
                maxSum= currLevelSum;
                maxLevel= currLevel;
            }
            currLevel++;
        }

        return maxLevel;

    }
}
