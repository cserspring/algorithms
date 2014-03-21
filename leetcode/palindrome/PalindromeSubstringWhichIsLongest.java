package palindrome;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one 
 * unique longest palindromic substring.
 * */

/*
 * 这里陷入定式思维了，用动态规划做的，
 * 其实这题原来做过，就是以i为中心点，不断地往两边扩张
 * */
public class PalindromeSubstringWhichIsLongest {
	public static String longestPalindrome(String s) {
		if (s==null)
			return null;
		int len = s.length();
		if (len == 0 || len == 1)
			return s;
		boolean[][] isPa = new boolean[len][len];
		for (int i = len-1; i >= 0; --i) {
			for (int j = i; j < len; ++j) {
				if (i==j) {
					isPa[i][j] = true;
				} else {
					isPa[i][j] = (s.charAt(i)==s.charAt(j) && (j-i<=2 || isPa[i+1][j-1]));
				}
			}
		}
		int left = 0;
		int right = 0;
		int num = 0;
		for (int i = 0; i < len; ++i) {
			for (int j = i; j < len; ++j) {
				if (isPa[i][j] && j-i > num) {
					num = j-i;
					left = i;
					right = j;
				}
			}
		}
		return s.substring(left, right+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aabaaaaa"));
	}

}
