/* To get the minmum number of coins to get the amount of P */
public class MinimalNumberOfCoins {
	// C(P) = min{C(P-Vi)} + 1
	public static int minNum(int[] coins, int N) {
		int[] dp = new int[N+1];
		int m = coins.length;
		dp[0] = 0;

		for (int i = 1; i <= N; ++i) {
			dp[i] = dp[i-coins[0]] + 1;
			for (int j = 1; j < m; ++j) {
				int remain = i - coins[j];
				if (remain >= 0) {
					int tmp = dp[remain] + 1;
					if (tmp < dp[i])
						dp[i] = tmp;
				}
			}
		}
		return dp[N];
	}
	
	public static void main(String args[]) {
		int[] coins = {1,2,3};
		int N = 10;
		System.out.println(minNum(coins, N));
	}
}
