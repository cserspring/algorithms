package dp;

/*
 * Given a string s and a dictionary of words dict, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 * */
import java.util.HashSet;
import java.util.Set;

public class WordBreakI {
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i < len + 1; ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dogsssss";
		Set<String> dict = new HashSet<String>();
		dict.add("dog");
		dict.add("s");
		dict.add("gs");
		System.out.println(wordBreak(s, dict));
	}

}
