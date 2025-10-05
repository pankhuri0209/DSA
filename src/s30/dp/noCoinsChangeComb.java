package s30.dp;

public class noCoinsChangeComb {
    public int change(int amount, int[] coins)
    {
        Integer[][] memo= new Integer[coins.length][amount+1];
        return helper(coins,0, amount, memo);
    }
    public int helper(int[] coins, int index, int amount, Integer[][] memo)
    {
        // base case: exact amount is reached
        if (amount == 0)
        {
            return 1;
        }
        // base case: negative amount or no more coins

        if (index >= coins.length || amount < 0)
        {
            return 0;
        }
        //check cached memo
        if (memo[index][amount] != null)
        {
            return memo[index][amount];
        }
        int ways=0;
        // Decision : How many times to use coins[index]
        for (int count=0; count * coins[index]<=amount; count++)
        {
            // after using coin 'count' times , find ways for remanining amount
            ways+=helper(coins, index+1, amount - count*coins[index], memo);
        }
        memo[index][amount] = ways;
        return ways;
    }

    //another way
    public int change1(int amount, int[] coins)
    {
        Integer[][] memo= new Integer[coins.length][amount+1];
        return helper1(coins,0,amount, memo);
    }
    public int helper1(int[] coins, int index, int amount, Integer[][] memo)
    {
        // base case: found exact match
        if (amount == 0)
        {
            return 1;
        }
        // base case: out of coins
        if (index>=coins.length)
        {
            return 0;
        }
        //cached value returned
        if (memo[index][amount] != null)
        {
            return memo[index][amount];
        }
        int ways=0;

        //option 1: skip current coin, move to next
        ways+=helper1(coins,index+1, amount, memo);


        //option 2: use current coin, stay at same index
        if (amount>=coins[index]) {
            ways+= helper1(coins, index+1, amount - coins[index], memo);
        }

        memo[index][amount] = ways;
        return ways;
    }
    //tabulation
    public int change2(int amount, int[] coins)
    {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        //base case : one way to make amount 0 .. use no coins
        for (int i=0;i<=n;i++)
        {
            dp[i][0]=1;
        }
        //build table
        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=amount;j++)
            {
                // dont use current coin
                dp[i][j]= dp[i-1][j];

                // use current coin
                if (j>=coins[i-1])
                {
                    dp[i][j]+= dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][amount];
    }
    /// space optimimzed

    public int change3(int amount, int[] coins)
    {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int coin : coins)
        {
            // update all amounts that can include this coin
            for (int j=coin;j<=amount;j++)
            {
                dp[j]+= dp[j-coin];
            }
        }
        return dp[amount];
    }
}
