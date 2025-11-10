package stripe;

import java.util.*;

public class minTransfers {
    public int minTransfers(int[][] transactions) {
        //1. build net balances
        Map<Integer,Integer> bal=new HashMap<>();
        for(int[] t:transactions){
            int from =t[0];
            int to=t[1];
            int amount=t[2];
            bal.put(from,bal.getOrDefault(from,0)-amount);
            bal.put(to,bal.getOrDefault(to,0)+amount);
        }
        //2. collect non zeroes balances
        List<Integer> list= new ArrayList<>();
        for (int v:bal.values()){
            if (v!=0) {
                list.add(v);
            }
        }
        // nothing to settle
        if (list.isEmpty()){
            return 0;
        }
        //backtracking
        return dfs(list,0);
    }
    public int dfs(List<Integer> debts,int start){
        //move start to first
        int n=  debts.size();
        while(start<n && debts.get(start)==0){
            start++;
        }
        if(start==n){
            return 0;
        }
        int res= Integer.MAX_VALUE;
        int curr= debts.get(start);

        //try to settle debts[start] with some j>start that has opposite sign
        Set<Integer> tried = new HashSet<>();
        for (int j= start+1; j<n; j++){
            int dj=  debts.get(j);
            if (dj==0 || (long) curr*dj>0)
            {
                continue;
            }
            tried.add(dj);

            //settle
            debts.set(j, j+curr);

            res= Math.min(res, 1+dfs(debts,start+1));

            //backtrack
            debts.set(j,dj);
            if (dj+curr==0)
            {
                break;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
