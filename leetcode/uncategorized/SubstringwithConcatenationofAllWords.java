package uncategorized;
/*
 You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	private ArrayList<Integer> res;
	private int wordlen;

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		res = new ArrayList<Integer>();

		int slen = S.length();
		int numwords = L.length;
		wordlen = L[0].length();
		int allwordslen = numwords * wordlen;
		if (slen < allwordslen)
			return res;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < numwords; ++i) {
			if (map.containsKey(L[i])) 
				map.put(L[i], map.get(L[i])+1);
			else 
				map.put(L[i], 1);
		}
		for (int i = 0; i <= slen-allwordslen; ++i) {
			if (determine(S.substring(i, i+allwordslen), new HashMap<String, Integer>(map))) {
				res.add(i);
			}
		}
		return this.res;
	}

	private boolean determine(String s, HashMap<String, Integer> map) {
		for (int i = 0; i < s.length(); i = i+wordlen) {
			String word = s.substring(i,i+wordlen);
			if (map.containsKey(word)) {
				map.put(word, map.get(word)-1);
			} else {
				return false;
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
		String[] L = { "foo", "bar" };
		System.out.println(s.findSubstring("barfoothefoobarman", L));
	}

}
