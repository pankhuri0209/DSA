package striver.bst;

import java.util.*;
// Node structure for the binary tree
class Node1 {
    int data;
    Node1 left;
    Node1 right;

    // Constructor to initialize
    // the node with a value
    public Node1(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class Pair{
    Node1 node;
    int line;

    public Pair(Node1 node, int line){
        this.node = node;
        this.line = line;
    }
}
public class bottomview {
    public ArrayList<Integer> bottomView(Node1 root)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null){return ans;}
        Map<Integer, Integer> map = new TreeMap<>();
       Queue<Pair> queue  = new LinkedList<Pair>();

       queue.offer(new Pair(root,0));

       while(!queue.isEmpty())
       {
           Pair p= queue.poll();
           Node1 node= p.node;
           int line= p.line;

           map.put(line,node.data);

           if(node.left!=null) queue.offer(new Pair(node.left, line-1));
           if (node.right!=null) queue.offer(new Pair(node.right, line+1));
       }
       for (int val : map.values())
       {ans.add(val);}
       return ans;
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.left.left = new Node1(4);
        root.left.right = new Node1(10);
        root.left.left.right = new Node1(5);
        root.left.left.right.right = new Node1(6);
        root.right = new Node1(3);
        root.right.right = new Node1(10);
        root.right.left = new Node1(9);

        bottomview solution = new bottomview();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for(int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}
