package dp;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 * */
public class DecodeWays {
	public static int numDecodingsII(String s) {
		if (s == null || s.length() == 0)
			return 0;

		if (s.charAt(0) == '0')
			return 0;

		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= len; ++i)
			dp[i] = 0;

		/* To determine whether the previous char is 0 */
		for (int i = 2; i <= len; ++i) {
			if (s.charAt(i - 1) == '0'
					&& (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')) {
				dp[i] = dp[i - 2];
			} else if (s.charAt(i - 1) == '0'
					&& (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2')) {
				return 0;
			} else if (s.charAt(i - 2) > '2'
					|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) > '6')) {
				dp[i] = dp[i - 1];
			} else if (s.charAt(i - 2) == '0') {
				dp[i] = dp[i - 3];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		return dp[len];
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		for (int i = 1; i <= len; ++i) {
			int c1 = 0;
			if (s.charAt(i - 1) != '0')
				c1 = dp[i - 1];
			int c2 = 0;
			if (i >= 2 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')))
				c2 = dp[i - 2];
			dp[i] = c1 + c2;
		}
		return dp[len];
	}

	public static void main(String args[]) {
		System.out.println(numDecodingsII("101"));
	}
}
