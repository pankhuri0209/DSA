package Neetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minCostCoverNodesUF {
    public int minCostConnectPoints(int[][] points) {
        int n= points.length;

        // step1: CREATE --all possible edges
        List<int[]> edges= new ArrayList<int[]>();
        for(int i=0;i<n;i++)    
        {
            for(int j=i+1;j<n;j++) {
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i, j, cost});
            }
        }

        // Step2: SORT-- based on the cost
        Collections.sort(edges, (a,b)->a[2]-b[2]);

        // Step3: PROCESS -- Add edges that don't create cycles
        UnionFind uf= new UnionFind(n);
        int totalCost =0;
        int edgesUsed=0;
        for(int[] edge:edges)
        {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (uf.union(from, to))
            {
                totalCost+=cost;
                edgesUsed++;

                if (edgesUsed==n-1)
                {
                    break;
                }
            }
        }
        return totalCost;
    }
    class UnionFind{
        private int[] parent;
        private int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX==rootY)
            {
                return false; // already connected
            }

            //union by rank
            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if (rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    //prims
    public int minCostConnectPoints1(int[][] points) {
        int n= points.length;

        //track which points are already in the MST
        boolean[] inMST= new boolean[n];

        //minimum cost to connect each point with MST
        int[] minCost= new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0]=0;

//        State:
//        inMST:   [F, F, F, F, F]  // No points in tree yet
//        minCost: [0, ∞, ∞, ∞, ∞]  // Point 0 costs 0, others unknown
//
//● Point 0 (ready to add)

        int totalCost=0;
        // add n points to MST
        for(int i=0;i<n;i++)
        {
            // STEP 1: Find the unconnected point with minimum cost
            int u=-1;
            for (int j=0;j<n;j++)
            {
                if (!inMST[j] && (u == -1 || minCost[j] < minCost[u])) {
                {
                    u=j;
                }
            }
            // STEP 2: Add this point to MST
            inMST[u] = true;
            totalCost += minCost[u];

            // STEP 3: Update costs to remaining points
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0]) +
                            Math.abs(points[u][1] - points[v][1]);
                    minCost[v] = Math.min(minCost[v], cost);
                }
//                Point 0 → Point 1: |0-2| + |0-2| = 4
//                Point 0 → Point 2: |0-3| + |0-10| = 13
//                Point 0 → Point 3: |0-5| + |0-2| = 7
//                Point 0 → Point 4: |0-7| + |0-0| = 7
            }
        }

        return totalCost;

    }
}
