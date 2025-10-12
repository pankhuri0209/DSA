package Neetcode.graphs;

import java.util.*;

public class findCheapestPrice {
    // solution 1: bfs with cost tracking
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //step1: build adj list: cit : [destination, price]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge:flights){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        //Step2: track minimum cost to reach each city
        int[] minCost = new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);

        //Queue: [city, cost, stops]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0,0});

        int res = Integer.MAX_VALUE;

        //step3: process
        while(!q.isEmpty()){

            int[] curr = q.poll();
            int city=curr[0];
            int cost=curr[1];
            int stops=curr[2];

            //if we have exceeded k stops , skip
            if (stops>k)
            {
                continue;
            }
            //if reach destination, update result
            if (city==dst)
            {
                res= Math.min(res,cost);
                continue;
            }
            //explore neighbors
            if (graph.containsKey(city))
            {
                for (int[] neigh:graph.get(city))
                {
                    int nextCity=neigh[0];
                    int price=neigh[1];
                    int newCost=cost+price;

                    if (newCost<minCost[nextCity])
                    {
                        minCost[nextCity]=newCost;
                        q.offer(new int[]{nextCity,newCost,stops+1});
                    }
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }



    }

