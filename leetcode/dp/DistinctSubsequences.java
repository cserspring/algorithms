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
 * ������Ҫʹ�ô������㡣ʹ��һ�� DP ���ɡ�
 * �ؼ�����εõ����ƹ�ϵ�����������룬��ĸ���ĳ���Ϊ j��  
 * �Ӵ��ĳ���Ϊ i������Ҫ��ľ��ǳ���Ϊ i ���ִ��ڳ���Ϊ j ��
 * ĸ���г��ֵĴ�������Ϊ t[i][j]����ĸ�������һ���ַ����Ӵ�
 * �����һ���ַ���ͬ���򳤶�Ϊ i ���Ӵ��ڳ���Ϊ j ��ĸ���г��ֵ�
 * ��������ĸ����ǰ j - 1 ���ַ����Ӵ����ֵĴ�����
 * �� t[i][j] = t[i][j - 1]��
 * ��ĸ�������һ���ַ����Ӵ������һ���ַ���ͬ����ô����ǰ j - 1 ��
 * �ַ������ִ��Ĵ����⣬��Ҫ�����Ӵ���ǰ i - 1 ���ַ���ĸ����ǰ j - 1 
 * ���ַ��г��ֵĴ������� 
 * t[i][j] = t[i][j - 1] + t[i - 1][j - 1]��  
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
