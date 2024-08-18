package capitalOne;

import java.util.Map;

public class coinChange {

    public int coinChange(int[] coins, int amount)
    {
        return coinChange(0, coins, amount);

    }
    private int coinChange(int idxcoin, int[] coins, int amount)
    {
        if (amount==0)
        {
            return 0;
        }
        if (idxcoin < coins.length && amount>0)
        {
            int maxVal= amount/ coins[idxcoin];
            int minCost = Integer.MAX_VALUE;
            for (int x=0; x<= maxVal ;x++)
            {
                if (amount>=x * coins[idxcoin])
                {
                    int res= coinChange(idxcoin+1, coins, amount-x * coins[idxcoin]);
                    if (res!=-1)
                    {
                        minCost = Math.min(minCost, res+x);
                    }
                }

            }
            return (minCost==Integer.MAX_VALUE ) ?-1 :minCost;
        }
        return -1;
    }
}
