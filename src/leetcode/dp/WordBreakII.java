package leetcode.dp;

/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

   Return all such possible sentences.

   For example, given
   s = "catsanddog",
   dict = ["cat", "cats", "and", "sand", "dog"].

   A solution is ["cats and dog", "cat sand dog"].
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s ==null || s.length() == 0)
			return res;
		int len = s.length();
		boolean[] dp = new boolean[len+1];
		dp[0] = true;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i < len+1; ++i) {
			for (int j = i-1;j >= 0;--j) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					if (map.containsKey(i)) {
						map.get(i).add(j);
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(j);
						map.put(i, tmp);
					}
				}
			}
		}
		
		if (dp[len]) {
			res = getResult(s, map, len);
		}
		return res;
    }
	
	private static ArrayList<String> getResult(String s, HashMap<Integer, ArrayList<Integer>> map, int key) {
		ArrayList<String> res = new ArrayList<String>();		
		if (key ==0) {
			res.add("");
			return res;
		}
		ArrayList<Integer> pos = map.get(key);
		for (int i = 0; i < pos.size(); ++i) {
			ArrayList<String> tmpRes = getResult(s, map, pos.get(i));
			for (int j = 0; j < tmpRes.size(); ++j) {
				String str = tmpRes.get(j) + " " + s.substring(pos.get(i), key);
				res.add(str.trim());
			}
		}
		return res;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak(s, dict));
	}

}
