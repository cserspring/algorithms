package uncategorized;

/*
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 * */

public class ReverseWordsinaString {
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;
		String res = "";
		int n = s.length();
		int end = n;
		int count = n-1;
		while (count >= 0) {
			if (end == n && s.charAt(count) != ' ') {
				end = count;
			} else if (end != n && s.charAt(count) == ' ') {
				res += s.substring(count+1, end+1) + " ";
				end = n;
			}
			if (end != n && count == 0 && s.charAt(count) != ' ') {
				res += s.substring(0, end+1) + " ";
				break;
			}
			--count;
		}
		return res.trim();
	}

	public static String reverseWordsI(String s) {
		if (s == null || s.length() == 0)
			return s;
		String[] arr = s.split("\\s+");
		for (int i = 0; i < arr.length / 2; ++i) {
			String tmp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = tmp;
		}
		String result = "";
		for (int i = 0; i < arr.length; ++i)
			result += arr[i] + " ";
		return result.trim();
	}
	
	public static void main(String args[]) {
		System.out.println(reverseWords(" i    am a    boy "));
	}
}
