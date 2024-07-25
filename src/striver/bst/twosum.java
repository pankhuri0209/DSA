package striver.bst;

import java.util.Stack;

public class twosum {
    public class BSTIterator {

        private Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean reverse = true;

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode tmpNode = stack.pop();
            if (reverse == false) {
                pushAll(tmpNode.right);
            } else {
                pushAll(tmpNode.left);
            }
            return tmpNode.val;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                if (reverse == true) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }


        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            BSTIterator l = new BSTIterator(root, false);
            BSTIterator r = new BSTIterator(root, true);

            int i = l.next();
            int j = r.next();

            while (i < j) {
                if (i + j == k) {
                    return true;
                } else if (i + j < k) {
                    if (l.hasNext()) {
                        i = l.next();
                    } else {
                        return false;
                    }
                } else {
                    if (r.hasNext()) {
                        j = r.next();
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;

        twosum solution = new twosum();
        boolean result = solution.findTarget(root, k);

        System.out.println("Result: " + result); // Expected output: true
    }
}
