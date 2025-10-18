package Neetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class serializeDeserialize {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializehelper(root,sb);
        return sb.toString();
    }
    private void serializehelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;}
        sb.append(root.val).append(",");
        serializehelper(root.left,sb);
        serializehelper(root.right,sb);
    }
    //decodes your encoded data to tree
    public TreeNode deserialize(String data) {
        String[] values= data.split(",");
        Queue<String> queue=new LinkedList<>(Arrays.asList(values));
        return deserializehelper(queue);
    }
    private TreeNode deserializehelper(Queue<String> queue) {
        String value=queue.poll();
        if(value.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializehelper(queue);
        root.right = deserializehelper(queue);
        return root;
    }
}
