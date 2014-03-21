package buysellstock;

import java.util.ArrayList;
import java.util.List;

/*
 Say you have an array for which the ith element is the price 
 of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete 
 at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time 
 (ie, you must sell the stock before you buy again).
 */
public class BuySellStockIII {
    // O(N)
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int sumProfit = 0;
        int low = prices[0];
        int profit = 0;
        List<Integer> forwardProfit = new ArrayList<Integer>();
        // Move forward
        for (int i = 0; i < prices.length; ++i) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i]-low);
            forwardProfit.add(profit);
        }
        
        int high = prices[prices.length-1];
        int sum = 0;
        profit = 0;
        // Move backward
        for (int i = prices.length-1; i >= 0; --i) {
            high = Math.max(high, prices[i]);
            profit = Math.max(profit, high-prices[i]);
            sum = forwardProfit.get(i)+profit;
            if (sumProfit < sum)
                sumProfit = sum;
        }
        return sumProfit;
    }

    // O(N^2)
    public static int maxProfitII(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; ++i) {
            int tmpProfit = partMax(prices, 0, i) + partMax(prices, i+1, prices.length-1);
            if (max < tmpProfit)
                max = tmpProfit;
        }
        return max;
    }
    
    private static int partMax(int[] prices, int start, int end) {
        if (start > end)
            return 0;
        int low = prices[start];
        int profit = 0;
        for (int i = start+1; i <= end; ++i) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i]-low);
        }
        return profit;
    }
    
    public static void main(String args[]) {
        int prices[] = {2,1};
        System.out.println(maxProfit(prices));
    }
}