package striver.bst;

import java.util.LinkedList;
import java.util.Queue;
class TNode {
    public int val;
    public TNode left;
    public TNode right;
    public TNode next;

    public TNode() {}

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, TNode _left, TNode _right, TNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class connect {
    TNode connectNodes(TNode root)
    {
        if(root== null)
        {
            return null;
        }
        Queue<TNode> q= new LinkedList<>();
        q.offer(root);
        while(q!=null)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TNode curr= q.poll();

                if(i<size-1)
                {
                    curr.next= q.peek();
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

            }
        }
        return root;

    }
}
