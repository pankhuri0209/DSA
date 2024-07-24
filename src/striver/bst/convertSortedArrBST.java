package striver.bst;

public class convertSortedArrBST {

    public  TreeNode convert(int[] nums)
    {
       if(nums.length==0)
       {
           return null;
       }
       return construct(0, nums, nums.length);

    }
    public TreeNode  construct(int start, int[] nums, int end)
    {
        if(start> end)
        {
            return null;
        }
        int mid= start+(end- start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left= construct(start, nums, mid);
        root.right = construct(mid+1, nums, end);
        return root;

    }
}
