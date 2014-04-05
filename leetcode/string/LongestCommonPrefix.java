package string;

/* Write a function to find the longest common prefix string amongst an array of strings. */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0)
        	return res;
        for (int j = 0; ; ++j) {
        	int i = 0;
        	if (j==strs[0].length())
        		break;
        	char c = strs[0].charAt(j);
        	for (i = 1; i < strs.length; ++i) {
        		if (strs[i].length() == j || strs[i].charAt(j) != c) {
        			return res;
        		}
        	}
        	res += c;
        }
        return res;
    }
	public static void main(String[] args) {
		String[] strs = {"a"};
		System.out.println(longestCommonPrefix(strs));
	}

}
