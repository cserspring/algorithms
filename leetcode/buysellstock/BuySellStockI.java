package buysellstock;
/*
Say you have an array for which the ith element is the price of a 
given stock on day i.

If you were only permitted to buy one share of the stock and sell one 
share of the stock, design an algorithm to find the best times to buy and sell.

The question is equivalent to the following:

Find i and j that maximizes Aj â€?Ai, where i < j.
There is an obvious O(N2) solution, but in fact we can do better in just O(N).
 */
public class BuySellStockI {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0)
            return 0;
        int min = 0;
        // We cannot initialize buy to be 0, otherwise it will be a bug, for example {4,3,2,1}
        int buy = -1;
        // We should use sell here to record min, don't use min at last, because min may be changed, but
        // it is not the "min" of the best price.
        int sell = 0;
        int maxdiff = 0;
        int diff = 0;
        for (int i = 1; i < len; ++i) {
            if (prices[min] > prices[i]) {
                min = i;    
            }
            diff = prices[i] - prices[min];
            if (diff > maxdiff) {
                maxdiff = diff;
                buy = i;
                sell = min;
            }
        }

        if (buy == -1)
            return 0;
        return prices[buy] - prices[sell];
    }

    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len <= 0)
            return 0;
        int profit = 0;
        int low = prices[0];
        for (int i = 1; i < len; ++i) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i] - low);
        }
        return profit;
    }
    
    public static void main(String args[]) {
        //{2,4,1}
        int prices[] = {2,1};
        System.out.println(maxProfit(prices));
    }
}
