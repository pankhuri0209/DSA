package striver.bst;

public class isSum {
    public static int isSumProperty(Node root)
    {
        // add your code here
        System.out.println();
        if (root == null || (root.left == null && root.right == null)) {
            return 1; // An empty tree or a leaf node satisfies the sum property
        }

        int left_data = (root.left != null) ? root.left.val : 0;
        int right_data = (root.right != null) ? root.right.val : 0;

        if (root.val == left_data + right_data &&
                isSumProperty(root.left) == 1 &&
                isSumProperty(root.right) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
