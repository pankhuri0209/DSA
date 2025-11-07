package stripe;

import java.util.*;

public class calcEquation {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    )
    {
        Map<String,Map<String,Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            String a= equations.get(i).get(0);
            String b=  equations.get(i).get(1);
            double val= values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0/val);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                res[i] = -1;
            }
            else if(src.equals(dst)) {
                res[i] = 1;

            }
            else {
                HashSet<String> visited = new HashSet<>();
                res[i]= dfs(graph,src, dst, 1, visited);
            }
        }
        return res;
    }
    private double dfs(Map<String, Map<String, Double>> graph, String curr, String dst, double product, HashSet<String> visited) {
        if (curr.equals(dst)) {
            return product;
        }
        visited.add(curr);
        for (String next: graph.get(curr).keySet()) {
            double ans= dfs(graph,next, dst,product*graph.get(curr).get(next),visited);
            if (ans!=-1.0) {return ans;}
        }
        return -1.0;
    }
}
