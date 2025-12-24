import java.util.Arrays;
import java.util.Map;

public class leetcode1066 {
    class Solution {
        int[][] workers, bikes;
        int m, n;
        int[] dp;

        public int assignBikes(int[][] workers, int[][] bikes) {
            this.workers = workers;
            this.bikes = bikes;
            m = workers.length;
            n = bikes.length;

            dp = new int[1<<n]; //? 2^n ; where n is the no of bikes

            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;

            for (int mask=0; mask< (1<<n); mask++) {
                int k= Integer.bitCount(mask); // worker index
                if (k>=m)
                {
                    continue;
                }
                for (int j=0; j<n; j++) //try every bike
                {
                    if((mask & (1<<j)) ==0)
                    {
                        int newMask = mask | (1<<j);
                        dp[newMask]= Math.min(dp[newMask], dp[mask] + dis(workers[k], bikes[j]));
                    }
                }
            }
            int ans= Integer.MAX_VALUE;
            for (int mask=0; mask< (1<<n); mask++) {
                if (Integer.bitCount(mask) == m)
                {
                    ans = Math.min(ans, dp[mask]);
                }
            }
            return ans;
        }
        private int dis(int[] a, int[] b) {
            return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
        }
    }
}
