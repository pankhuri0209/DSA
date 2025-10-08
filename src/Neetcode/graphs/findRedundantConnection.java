package Neetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        //try adding edges one by one
        for (int[] edge:edges)
        {
            Set<Integer> visited = new HashSet<>();
            if (hasCycle(edge[0],-1, graph, visited, edge[1]))
            {
                return edge;
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return new int[0];
    }
    private boolean hasCycle(int node, int parent, List<List<Integer>> graph,
                             Set<Integer> visited, int target) {
    {
        if (node == target) return true;
        visited.add(node);
        for (int neigh:graph.get(node))
        {
            if (!visited.contains(neigh))
            {
                if (hasCycle(neigh,parent,graph,visited,target)) return true;
            }
        }
        return false;
    }
}

//
public int[] findRedundantConnection1(int[][] edges) {

        int n = edges.length;
        int[] parents = new int[n+1];

}

}
