package Neetcode.graphs;

import java.util.*;

public class findItenary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // step1: build adj list with priority queue with lexicography order

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            //use pq to automatically sort destinations alphabetically
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }
        // step2: perform dfs starting from "JFK"
        LinkedList<String> path = new LinkedList<>();
        dfs("JFK", graph, path);
        return path;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> graph, LinkedList<String> path) {
        PriorityQueue<String> queue = graph.get(from);

        // visit all destinations from the airport "from"
        while (queue!=null && !queue.isEmpty()){
            String next = queue.poll();
            dfs(next, graph, path);
        }
        path.addFirst(from);
    }
}
