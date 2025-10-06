package Neetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class isValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length!=n-1)
        {
            return false;
        }

        //build adj list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(0,graph,visited);
        return visited.size() == n;

    }
    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for(int neighbour:graph.get(node))
        {
            if (!visited.contains(neighbour)) dfs(neighbour,graph,visited);
        }
    }
}
