package stripe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class clonegraphs {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            neighbors = new ArrayList<Node>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
    Map<Node, Node> map = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
