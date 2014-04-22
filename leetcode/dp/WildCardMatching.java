package dp;

public class WildCardMatching {
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		int slen = s.length();
		int plen = p.length();
		int i = 0;
		int j = 0;
		int prevs = 0;
		int star = -1;
		while (i < slen) {
			if ((j < plen && p.charAt(j) == '?')
					|| (j < plen && p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
				continue;
			}
			if (j < plen && p.charAt(j) == '*') {
				star = j++;
				prevs = i;
				continue;
			}
			if (star != -1) {
				j = star + 1;
				i = ++prevs;
				continue;
			}
			return false;
		}
		while (j < plen && p.charAt(j) == '*')
			j++;
		return j == plen;
	}

	public static void main(String args[]) {
		System.out.println(isMatch("aa", "a"));
	}
}
