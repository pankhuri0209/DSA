package striver.graphs;

import java.util.ArrayList;

public class noofProvinces {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int visited[])
    {
        visited[node]=1;
        for(Integer it: adjList.get(node))
        {
            if(visited[it]==0)
            {
                dfs(it, adjList, visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V)
    {
        ArrayList<ArrayList<Integer>> adjLis= new ArrayList<>();
        for (int i=0;i<V;i++)
        {
            adjLis.add(new ArrayList<Integer>());
        }

        //changing adj matrix to list
        for (int i=0;i<V;i++)
        {
            for (int j=0;j<V;j++)
            {
                if(adj.get(i).get(j) ==1 && i!=j)
                {
                    adjLis.get(i).add(j);
                    adjLis.get(j).add(i);
                }
            }
        }
        int vis[] =new int[V];
        int cnt=0;
        for (int i=0;i<V;i++)
        {
            if (vis[i]==0)
            {
                cnt++;
                dfs(i, adjLis, vis);
            }
        }
        return cnt;
    }
}
