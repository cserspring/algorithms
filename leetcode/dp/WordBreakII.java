package dp;

/*
 * Given a string s and a dictionary of words dict, add spaces in s to 
 * construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null)
			return res;
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= n; ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					if (map.containsKey(i)) {
						map.get(i).add(j);
					} else {
						ArrayList<Integer> ints = new ArrayList<Integer>();
						ints.add(j);
						map.put(i, ints);
					}
				}
			}
		}
		if (dp[n]) {
			String result = "";
			getResult(res, map, s, result, n);
		}
		return res;
	}

	private void getResult(ArrayList<String> res,
			HashMap<Integer, ArrayList<Integer>> map, String src,
			String result, int index) {
		if (index == 0) {
			res.add(result.trim());
			return;
		}
		ArrayList<Integer> prevIndex = map.get(index);
		int size = prevIndex.size();
		for (int i = 0; i < size; ++i) {
			int p = prevIndex.get(i);
			String newResult = " " + src.substring(p, index) + result; // Use newResult here
			getResult(res, map, src, newResult, p);
		}
	}
}
