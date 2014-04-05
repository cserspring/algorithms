package string;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstringII(String s) {
        int n = s.length();
        if (n == 0)
        	return 0;
        int max=1;
        
        for (int i = 0; i < n-1; ++i) {
        	HashSet<Character> set = new HashSet<Character>();
        	set.add(s.charAt(i));
        	for (int j = i+1; j < n; ++j) {
        		if (set.contains(s.charAt(j))) {
        			int size = set.size();
        			if (size > max)
        				max = size;
        			break;
        		}
        		set.add(s.charAt(j));
        	}
        }
        return max;
    }
	
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
        if (n == 0)
        	return 0;
        int max=1;
        boolean[] flag = new boolean[256];
        Arrays.fill(flag, false);
        int i = 0;
        int j = 0;
        while (j < n) {
        	char c = s.charAt(j);
        	if (flag[c]) {
        		max = Math.max(max, j-i);
        		while (s.charAt(i)!=s.charAt(j)) {
        			flag[s.charAt(i)] = false;
        			i++;
        		}
        		i++;
        		j++;
        	} else {
        		flag[c] = true;
        		j++;
        	}
        }
        max = Math.max(max, n-i);
        return max;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcaaa"));
	}
}
