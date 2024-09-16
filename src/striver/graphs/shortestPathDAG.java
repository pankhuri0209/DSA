package striver.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class shortestPathDAG {

    public int[] shortestPath(int N, int M, int[][] edges)
    {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for (int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];
            int wt= edge[2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] dist= new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0]=0;

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);

        while (!deque.isEmpty())
        {
            int node= deque.pollFirst();

            for (Pair neighbor: adj.get(node))
            {
                int v= neighbor.first;
                int wt= neighbor.second;

                if (dist[node]+wt <dist[v])
                {
                    dist[v]= dist[node]+wt;
                    if (wt==0)
                    {
                        deque.addFirst(v);
                    }
                    else {
                        deque.addLast(v);
                    }
                }
            }
        }

        for (int i=0;i<N;i++)
        {
            if (dist[i]== (int)1e9)
            {
                dist[i]=-1;
            }
        }
        return dist;

    }


    static class Pair
    {
        int first, second;
        Pair(int first, int second)
        {
            this.first= first;
            this.second= second;
        }
    }
}


