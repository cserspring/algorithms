package uncategorized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		int n = strs.length;
		for (int i = 0; i < n; ++i) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String base = String.valueOf(chars);
			if (map.containsKey(base)) {
				map.get(base).add(strs[i]);
			} else {
				ArrayList<String> anagrams = new ArrayList<String>();
				anagrams.add(strs[i]);
				map.put(base, anagrams);
			}
		}

		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				res.addAll(entry.getValue());
			}
		}
		return res;
	}

	public ArrayList<String> anagramsII(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int n = strs.length;
		for (int i = 0; i < n; ++i) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String base = String.valueOf(chars);
			if (map.containsKey(base)) {
				res.add(strs[i]);
				if (map.get(base) != -1) {
					res.add(strs[map.get(base)]);
					map.put(base, -1);
				}
			} else {
				map.put(base, i);
			}
		}
		return res;
	}

	public ArrayList<String> anagramsIII(String[] strs) {
		// ArrayList<String> res = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return new ArrayList<String>();
		HashSet<String> res = new HashSet<String>();
		for (int i = 0; i < strs.length; ++i) {
			for (int j = i + 1; j < strs.length; ++j) {
				if (isAnagram(strs[i], strs[j])) {
					res.add(strs[i]);
					res.add(strs[j]);
				}
			}
		}
		return new ArrayList<String>(res);
	}

	private boolean isAnagram(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2)
			return false;
		int[] count = new int[26];
		for (int i = 0; i < 26; ++i) {
			count[i] = 0;
		}

		for (int i = 0; i < len1; ++i) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; ++i) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
