package dp;
/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

	For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",
	
	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.
 * */
public class InterleavingString {
	/*
	 * match[i][j] = match[i][j-1]     if s2[j-1] == s3[i+j-1]
	 * match[i][j] = match[i-1][j]     if s2[i-1] == s3[i+j-1]
	 * */
	public static boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
        	return false;
        boolean[][] dp = new boolean[len1+1][len2+1];
        for (int i = 0; i <= len1; ++i) {
        	for (int j = 0; j <= len2; ++j) {
        		dp[i][j] = false;
        	}
        }
        dp[0][0] = true;
        for (int i = 1; i <= len1; ++i) {
        	if (s1.charAt(i-1) == s3.charAt(i-1))
        		dp[i][0] = dp[i-1][0];
        	else
        		dp[i][0] = false;
        }
        for (int i = 1; i <= len2; ++i) {
        	if (s2.charAt(i-1) == s3.charAt(i-1))
        		dp[0][i] = dp[0][i-1];
        	else
        		dp[0][i] = false;
        }
        
        for (int i = 1; i <= len1; ++i) {
        	for (int j = 1; j <= len2; ++j) {
        		dp[i][j] = ((s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[i][j-1]) ||
        				((s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[i-1][j]);
        	}
        }
		return dp[len1][len2];
	}
	
	public static boolean isInterleaveII(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 == 0 && len2 == 0 && len3 == 0)
        	return true;
        if (len1 + len2 != len3)
        	return false;
        if (len1 == 0) {
        	if (s2.equals(s3))
        		return true;
        	return false;
        }
        if (len2 == 0) {
        	if (s1.equals(s3))
        		return true;
        	return false;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if (s3.charAt(0) == s1.charAt(0)) {
        	flag1 =  isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        if (s3.charAt(0) == s2.charAt(0)) {
        	flag2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return flag1 || flag2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		//String s3 = "aadbbcbcac";
		String s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1,s2,s3));
	}

}
