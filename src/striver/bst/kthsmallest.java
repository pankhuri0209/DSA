package striver.bst;

public class kthsmallest {

    public int[] findKth(TreeNode root, int k)
    {
        int [] kSmallest= new int[] {Integer.MIN_VALUE};
        int[] kLargest = new int[] {Integer.MIN_VALUE};

        //counter to track visited nodes
        int[] counter= new int[]{0};

        //find kth smallest element
        inorder(root, counter, k, kSmallest);

        //reset counter for kth largest element
        counter[0]=0;

        //find ktb largest element
        //perform reverse inorder traversal
        reversaInorder(root, counter, k, kLargest);

        return new int[]{kSmallest[0],kLargest[0]};
    }
    private void inorder(TreeNode node, int[] counter, int k, int[] kSmallest)
    {
        if(node==null || counter[0]>=k){return;}

        //traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        //increment counter after visiting left subtree
        counter[0]++;

        //check if current node is the kth smallest
        if(counter[0]==k)
        {
            kSmallest[0] = node.val;
            return;
        }
        //traverse right if kth smallest not found
        inorder(node.right, counter, k, kSmallest);
    }
    private  void reversaInorder(TreeNode node, int[] counter, int k, int[] kLargest)
    {
        if(node ==null || counter[0]>=k ){return;}

        //traverse right subtree
        reversaInorder(node.right, counter, k, kLargest);

        // increment counter after visting right subtree
        counter[0]++;

        //check if current node is the kth largest
        if(counter[0] ==k)
        {
            kLargest[0] = node.val;
            return;
        }

        //traverse left subtree if kth largest is not found yet
        reversaInorder(node.left, counter, k, kLargest);

    }

}
