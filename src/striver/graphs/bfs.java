package striver.graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    //{ Driver Code Starts
// Initial Template for Java

    class GFG {


        //   class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here

            ArrayList<Integer> bfs = new ArrayList<>();
            boolean vis[] = new boolean[V];
            Queue<Integer> q = new LinkedList<>();

            q.add(0);
            vis[0] = false;

            while (!q.isEmpty()) {
                Integer node = q.poll();
                bfs.add(node);

                for (Integer it : adj.get(node)) {
                    if (vis[it] == false) {
                        vis[it] = true;
                        q.add(it);
                    }
                }
            }
            return bfs;
        }
    }

}