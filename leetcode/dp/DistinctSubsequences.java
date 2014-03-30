package dp;
/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

	A subsequence of a string is a new string which is formed from the original 
	string by deleting some (can be none) of the characters without disturbing the 
	relative positions of the remaining characters. 
	(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	
	Here is an example:
	S = "rabbbit", T = "rabbit"

    Return 3.
 * 此题需要使用大数运算。使用一点 DP 即可。
 * 关键是如何得到递推关系，可以这样想，设母串的长度为 j，  
 * 子串的长度为 i，我们要求的就是长度为 i 的字串在长度为 j 的
 * 母串中出现的次数，设为 t[i][j]，若母串的最后一个字符与子串
 * 的最后一个字符不同，则长度为 i 的子串在长度为 j 的母串中出现的
 * 次数就是母串的前 j - 1 个字符中子串出现的次数，
 * 即 t[i][j] = t[i][j - 1]，
 * 若母串的最后一个字符与子串的最后一个字符相同，那么除了前 j - 1 个
 * 字符出现字串的次数外，还要加上子串的前 i - 1 个字符在母串的前 j - 1 
 * 个字符中出现的次数，即 
 * t[i][j] = t[i][j - 1] + t[i - 1][j - 1]。  
 * */
public class DistinctSubsequences {
	public static int numDistinct(String S, String T) {
		int slen = S.length();
		int tlen = T.length();
		if (tlen > slen)
			return 0;
		int[][] dp = new int[tlen+1][slen+1];
		dp[0][0] = 1;
		for (int i = 1; i < tlen + 1; ++i)
			dp[i][0] = 0;
		for (int i = 1; i < slen + 1; ++i)
			dp[0][i] = 1;
		for (int i = 1; i <= tlen; ++i) {
			for (int j = 1; j <= slen; ++j) {
				if (T.charAt(i-1) == S.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				else
					dp[i][j] = dp[i][j-1];
			}
		}
        return dp[tlen][slen];
    }
	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
}
