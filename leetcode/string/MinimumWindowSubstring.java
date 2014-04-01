package string;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public static String minWindow(String S, String T) {
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        HashMap<Character, Integer> base = new HashMap<Character, Integer>();
        int n = T.length();
        for (int i = 0; i < n; ++i) {
        	char c = T.charAt(i);
        	if (!base.containsKey(c)) {
        		found.put(c, 0);
        		base.put(c, 1);
        	} else {
        		base.put(c, base.get(c) + 1);
        	}
        }
        n = S.length();
        int count = 0;
        int ss = -1;
        int ee = n;
        for (int start =0, end = 0; end < n; ++end) {
        	char c = S.charAt(end);
        	if (base.containsKey(c)) {
        		found.put(c, found.get(c) + 1);
        		if (found.get(c) <= base.get(c))
        			++count;
        		if (count == T.length()) {
        			while (!base.containsKey(S.charAt(start)) || 
        					found.get(S.charAt(start)) > base.get(S.charAt(start))) {
        				if (base.containsKey(S.charAt(start)) && 
        						found.get(S.charAt(start)) > base.get(S.charAt(start))) {
        					found.put(S.charAt(start), found.get(S.charAt(start))-1);
        				}
        				++start;
        			}
        			if (end-start < ee-ss) {
        				ee = end;
        				ss = start;
        			}
        		}
        	}
        }
        
        return ss == -1 ? "":S.substring(ss, ee+1);
    }
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

}
