package striver.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class igzag {

    public List<List<Integer>> zigzag(TreeNode root)
    {
        List<List<Integer>> res= new ArrayList<>();

        if(root==null)
        {
            return res;
        }
        boolean zigzag= false;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int size  = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                list.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                //list.add(q.)
            }
            zigzag = !zigzag;
            res.add(list);
        }
        return res;

    }
}
