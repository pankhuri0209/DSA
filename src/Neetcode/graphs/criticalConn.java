package Neetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class criticalConn {

    List<List<Integer>> result;
    List<Integer>[] graph;
    int[] disc, low;
    int time;

    public List<List<Integer>> criticalConn(int n, List<List<Integer>> connections) {
        result = new ArrayList<>();
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> e : connections) {
            int u = e.get(0), v = e.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);
        time = 0;

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) dfs(i, -1);
        }

        return result;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = time++;

        for (int v : graph[u]) {
            if (v == parent) continue;

            if (disc[v] == -1) { // tree edge
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v)); // (u,v) is a bridge
                }
            } else { // back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
