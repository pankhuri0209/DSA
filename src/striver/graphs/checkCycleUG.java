package striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class checkCycleUG {
    class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public  boolean checkForCycleBFS(ArrayList<ArrayList<Integer>> adj, int s,
                                  boolean vis[])
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;

        // until the queue is empty
        while(!q.isEmpty())
        {
            // source node and its parent node
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            // go to all the adjacent nodes
            for(Integer it: adj.get(node))
            {
                if(vis[it]==false)
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // if adjacent node is visited and is not its own parent node
                else if(par != it) return true;

            }
        }

        return false;
    }



    public  boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
     //   int parent[] = new int[V];
     //   Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(checkForCycleBFS(adj, i,vis))
                    return true;

        return false;

    }

    ///dfs
    public boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] =new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,-1,vis,adj) ==false)
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int adjNode: adj.get(node))
        {
            if(vis[adjNode] ==0)
            {
                if(dfs(adjNode, node, vis, adj) == true)
                {
                    return true;
                }
            } else if (adjNode!=parent) {
                return true;

            }
        }
        return  false;
    }

}
