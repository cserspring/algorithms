package palindrome;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

   Return the minimum cuts needed for a palindrome partitioning of s.

   For example, given s = "aab",
   Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * */
public class PalindromePartitioningII {
	public int minCut(String s) {
        if (s==null || s.length()==0)
        	return 0;
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        
        for (int i = len-1; i >= 0; --i) {
        	for (int j = i; j < len; ++j) {
        		if (i==j) {
        			isPalindrome[i][j] = true;
        		} else {
        			isPalindrome[i][j] = isEqual(s, i,j) && (j - i <= 2 || isPalindrome[i+1][j-1]);
        		}
        	}
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; ++i)
        	dp[i] = i;
        for (int i = 0; i < len; ++i) {
        	if (isPalindrome[0][i]) {
        		dp[i] = 0;
        	} else {
        		for (int j = 0; j < i; ++j) {
        			if (isPalindrome[j+1][i] && dp[i] > 1+ dp[j])
        				dp[i] = 1+dp[j];
        		}
        	}
        }
        return dp[len-1];
	}
	
	private boolean isEqual(String s, int i, int j) {
		return s.charAt(i) == s.charAt(j);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII p = new PalindromePartitioningII();
		System.out.println(p.minCut("abbab"));
	}

}
