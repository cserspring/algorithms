package buysellstock;
public class BuySellStockII {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1)
            return 0;
        int profit = 0;
        for (int i = 0; i < len-1; ++i) {
            int delta = prices[i+1] - prices[i]; 
            if (delta > 0)
                profit += delta;
        }
        return profit;
    }
    
    public static void main(String args[]) {
        int prices[] = {1,0,9,10};
        System.out.println(maxProfit(prices));
    }
}