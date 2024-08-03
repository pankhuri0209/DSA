package striver.graphs;

import java.util.ArrayList;

public class dfs {


    public static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls)
    {
        visited[node] = true;
        ls.add(node);

        for(Integer it: adj.get(node))
        {
            if(visited[it] ==false)
            {
                dfs(it, visited, adj, ls);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {

        boolean visited[] = new boolean[V+1];
        visited[0]=true;
        ArrayList<Integer> ls= new ArrayList<>();
        dfs(0,visited, adj, ls);
        return ls;
    }
}
