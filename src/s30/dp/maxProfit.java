package s30.dp;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //memo [i][state]
        // state:0 = can buy, 1 = holding stock, 2= just sold/ cooldown

        Integer[][] memo = new Integer[n][3];
        return helper(prices,0,0,memo);
    }
    private int helper(int[] prices, int day, int state, Integer[][] memo)
    {
        //base case: no more days
        if (day>= prices.length)
        {
            return 0;
        }
        // returning the cached value
        if (memo[day][state]!=null)
        {
            return memo[day][state];
        }
        int profit=0;
        if (state==0)
        {
            //can buy or rest
            int buy= helper(prices,day+1,1,memo) - prices[day];
            int rest=  helper(prices,day+1,0,memo) ;
            profit=Math.max(buy,rest);
        }
        else if (state==1) {
            //holding: can sell or hold
            int sell = helper(prices, day + 1, 2, memo) + prices[day];
            int hold= helper(prices, day + 1, 1, memo);
            profit=Math.max(sell,hold);
        }
        else {
            //cooldown :must rest today
            profit = helper(prices, day+1, 0, memo);
        }
        memo[day][state] = profit;
        return profit;
    }
}
