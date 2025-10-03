package s30.dp;

import java.util.Arrays;

public class coinsChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo= new int[amount+1];
        Arrays.fill(memo, -2);
        return helper(coins, memo, amount);
    }
    private int helper(int[] coins, int[] memo, int amount) {
        if (amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(memo[amount] != -2) return memo[amount];
        int minCoins= Integer.MAX_VALUE;
        for (int coin: coins) {
            int result = helper(coins, memo, amount - coin);
            if(result!=Integer.MAX_VALUE)
            {
                minCoins= Math.min(minCoins, result+1);
            }
        }
        memo[amount] = minCoins;


        return minCoins;
    }

    //tabulation
    public int coinChange1(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]= 0; //0 coins needed to make 0

        for (int i = 1; i <= amount; i++) {
            // try each coin
            for (int coin: coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
