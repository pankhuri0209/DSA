package striver.graphs;

import java.util.ArrayList;
import java.util.List;

public class pathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res= new ArrayList<>();
        if(root==null)
        {
            return  res;
        }
        dfs(res, new ArrayList<Integer>(), root, targetSum);

        return res;
    }
    void dfs(List<List<Integer>> res, List<Integer> path,TreeNode root, int targetSum)
    {
        if(root==null)
        {return;}
        path.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val)
        {
            res.add(path);
        }
        else {
            dfs(res, path, root.left, targetSum);
            dfs(res, path, root.right, targetSum);
        }
        path.remove(path.size()-1);
    }

}
