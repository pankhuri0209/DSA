package Neetcode.graphs;

import java.util.*;

public class cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Node,Node> map = new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {

        //null check
        if (node == null) return null;

        //already clones, then return the clone
        if(map.containsKey(node))
            return map.get(node);

        //create a clone of the current node
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;

    }

    //revise dfs
    Map<Node, Node> visited= new HashMap<Node, Node>();
    public Node cloneGraphdfs(Node node) {
        // null check
        if (node == null) return null;

        if (visited.containsKey(node))
            return visited.get(node);

        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(cloneGraphdfs(neighbor));
        }

        return newNode;
    }
    //revise dfs1
    Map<Node, Node> visitedMap =new HashMap<Node, Node>();
    public Node clonegraphs(Node node)
    {
        if (node == null) return null;
        if (visitedMap.containsKey(node))
            return visitedMap.get(node);
        Node newNode = new Node(node.val);
        visitedMap.put(node, newNode);
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(clonegraphs(neighbor));
        }
        return newNode;

    }

    public Node cloneGraphbfs(Node node) {
        if (node == null) return null;
        HashMap<Node,Node> visited = new HashMap<Node,Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        Node cloneNode = new Node(node.val);
        visited.put(node,cloneNode);

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            for(Node neighbor : curNode.neighbors){
                if(!visited.containsKey(curNode)){
                    visited.put(curNode,new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                // we take the clone node using get(currNode) and then take the neighbor list and add cloned nodes from map
                // cloned node k neighbor list mai we are adding clones nodes using neighbors of the curr node
                visited.get(curNode).neighbors.add(visitedMap.get(neighbor));
            }
        }
        return cloneNode;
    }
}
