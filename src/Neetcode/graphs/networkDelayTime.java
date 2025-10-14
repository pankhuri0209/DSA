package Neetcode.graphs;

import java.util.*;

public class networkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        // step1 : build adj list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
                         graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[0]});
                     }
            //dijkstra's algorithm
            int[] dist= new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[k]=0;
            PriorityQueue<int[]> pq = new PriorityQueue<>();
            pq.offer(new int[]{k,0});
            while (!pq.isEmpty()){
                int[] cur = pq.poll();
                int node = cur[0];
                int time = cur[1];


                if (graph.containsKey(node)){
                    for (int[] edge : graph.get(node)){
                        int neighbour = edge[0];
                        int newTime = time + edge[1];

                        if(newTime<dist[neighbour]){
                            dist[neighbour] = newTime;
                            pq.offer(new int[]{neighbour,newTime});
                        }
                    }
                }
            }
            //find max time
            int maxTime=0;
            for (int i=1;i<=n;i++)
            {
                if (dist[i]==Integer.MAX_VALUE)
                {
                    return -1;
                }
                maxTime=Math.max(maxTime,dist[i]);
            }
        return  maxTime;
    }
}
