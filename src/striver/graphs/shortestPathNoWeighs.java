package striver.graphs;

import java.util.*;

public class shortestPathNoWeighs {

    static void printShortestDistance(List<List<Integer>> graph, int S, int D, int V)
    {
        List<Integer> par= new ArrayList<>(Collections.nCopies(V,-1));
        List<Integer> dist= new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

        bfs(graph, S, par, dist);

        if (dist.get(D) == Integer.MAX_VALUE)
        {
            System.out.println("Source and Destination are not connected");
            return;
        }
        List<Integer> path = new ArrayList<>();
        int currentNode = D;
        path.add(D);
        while (par.get(currentNode) !=-1) // backtracking
        {
            path.add(par.get(currentNode));
            currentNode= par.get(currentNode);
        }
        for (int i=path.size()-1;i>=0;i--)
        {
            System.out.println(path.get(i)+" ");
        }
    }
    static  void bfs(List<List<Integer>>graph, int S, List<Integer> par, List<Integer> dist)
    {
        Queue<Integer> q= new LinkedList<>();
        dist.set(S,0);
        q.add(S);
        while (!q.isEmpty())
        {
            int node= q.poll();
            for (int neighbor: graph.get(node))
            {
                if (dist.get(neighbor) == Integer.MAX_VALUE)
                {
                    par.set(neighbor, node);
                    dist.set(neighbor, dist.get(node)+1);
                    q.add(neighbor);
                }
            }
        }
    }
    // Driver program to test above functions
    public static void main(String[] args)
    {
        // no. of vertices
        int V = 8;
        // Source and Destination vertex
        int S = 2, D = 6;
        // Edge list
        List<List<Integer> > edges = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(0, 3), Arrays.asList(3, 4),
                Arrays.asList(4, 7), Arrays.asList(3, 7),
                Arrays.asList(6, 7), Arrays.asList(4, 5),
                Arrays.asList(4, 6), Arrays.asList(5, 6));

        // List to store the graph as an adjacency list
        List<List<Integer> > graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        printShortestDistance(graph, S, D, V);
    }
}
