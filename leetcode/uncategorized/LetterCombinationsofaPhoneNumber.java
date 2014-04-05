package uncategorized;
/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */
import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
	public static ArrayList<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno",
        		"pqrs", "tuv", "wxyz"};
        ArrayList<String> res = new ArrayList<String>();
        String str = "";
        dfs(res, digits, map, str);
        return res;
    }
	
	private static void dfs(ArrayList<String> res, String digits, String[] map, String str) {
		if (digits.length() == 0) {
			res.add(str);
			return;
		}
		char c = digits.charAt(0);
		for (int i = 0; i < map[c - '0'].length(); ++i) {
			String newStr = str + map[c - '0'].charAt(i);
			dfs(res, digits.substring(1), map, newStr);
		}
	}
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}
