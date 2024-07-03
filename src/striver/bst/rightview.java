package striver.bst;

import java.util.ArrayList;


class Node {
    int val;
    Node left;
    Node right;

    public Node(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class rightview {

    public ArrayList<Integer> rview(Node root)
    {
        ArrayList<Integer> res= new ArrayList<>();
        helper(root,res,0);
        return res;
    }
    public void helper(Node root, ArrayList<Integer> res, int depth)
    {
        if(root==null){return;}
        if(depth == res.size()){res.add(root.val);}

        helper(root.right, res, depth+1);
        helper(root.left, res, depth+1);
    }
}
