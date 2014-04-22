/* Find the number of ways to coin change 
 * C(N, m) = C(N, m-1) + C(N-Dm, m)
 * */
public class NumberOfWaysCoinChange {
	public static int numberOfWays(int[] d, int n) {
		int m = d.length;
		int[][] dp = new int[n + 1][m + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; ++i) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= m; ++i) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				dp[i][j] = dp[i][j - 1]
						+ (((i - d[j - 1]) >= 0) ? dp[i - d[j - 1]][j] : 0);
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		int[] d = { 8, 12, 7 };
		int n = 10;
		System.out.println(numberOfWays(d, n));
	}

}
