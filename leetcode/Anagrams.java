package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Anagrams {
	public static ArrayList<String> anagramsII(String[] strs) {
		//ArrayList<String> res = new ArrayList<String>();
		if (strs == null || strs.length==0)
			return new ArrayList<String>();
		HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length;++i) {
			String tmp = strs[i];
			char[] arr = tmp.toCharArray();
			Arrays.sort(arr);
			tmp = String.valueOf(arr);
			if (dict.containsKey(tmp)) {
				dict.get(tmp).add(strs[i]);
			} else {
				ArrayList<String> subRes = new ArrayList<String>();
				subRes.add(strs[i]);
				dict.put(tmp, subRes);
			}
		}
		ArrayList<String> res = new ArrayList<String>();
		for (Map.Entry<String, ArrayList<String>> e : dict.entrySet()) {
			if (e.getValue().size() > 1) {
				res.addAll(e.getValue());
			}
		}
		return res;
    }
	
	public static ArrayList<String> anagrams(String[] strs) {
		//ArrayList<String> res = new ArrayList<String>();
		if (strs == null || strs.length==0)
			return new ArrayList<String>();
		HashSet<String> res = new HashSet<String>();
		for (int i = 0; i < strs.length; ++i) {
			for (int j = i+1; j< strs.length; ++j) {
				if (isAnagram(strs[i], strs[j])) {
					res.add(strs[i]);
					res.add(strs[j]);
				}
			}
		}
		return new ArrayList<String>(res);
    }
	
	private static boolean isAnagram(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2)
			return false;
		int[] count = new int[26];
		for (int i = 0; i < 26; ++i) {
			count[i] = 0;
		}
		
		for (int i = 0; i < len1; ++i) {
			count[s1.charAt(i)-'a']++;
			count[s2.charAt(i)-'a']--;
		}
		for (int i = 0; i < 26; ++i) {
			if (count[i] !=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sts[] = {"", ""};
		System.out.println(anagramsII(sts));
	}

}
