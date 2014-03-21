package palindrome;

import java.util.ArrayList;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

   Return all possible palindrome partitioning of s.

   For example, given s = "aab",
   Return

    [
    ["aa","b"],
    ["a","a","b"]
    ]
 * */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s == null)
			return res;
		ArrayList<String> oneResult = new ArrayList<String>();
		if (isPalindrome(s)) {
			oneResult.add(s);
			res.add(new ArrayList<String>(oneResult));
		}
		ArrayList<ArrayList<String>> otherRes = partitionHelper(s);
		for (int i = 0; i < otherRes.size(); ++i) {
			res.add(otherRes.get(i));
		}
		return res;
    }
	
	public ArrayList<ArrayList<String>> partitionHelper(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s == null)
			return res;
		ArrayList<String> oneResult = new ArrayList<String>();
		for (int i = 1; i <= s.length() -1; ++i) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i,s.length());
			
			if (isPalindrome(s1)) {
				if (isPalindrome(s2)) {
					oneResult.add(s1);
					oneResult.add(s2);
					res.add(new ArrayList<String>(oneResult));
					oneResult.clear();
				} 

					ArrayList<ArrayList<String>> tmpRes = partitionHelper(s2);
					for (int j = 0; j < tmpRes.size(); ++j) {
						ArrayList<String> partialResult = tmpRes.get(j);
						oneResult.add(s1);
						oneResult.addAll(partialResult);
						res.add(new ArrayList<String>(oneResult));
						oneResult.clear();
					}
				
			}
		}
		return res;
    }
	
	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; ++i) {
			if (s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning p = new PalindromePartitioning();
		System.out.println(p.partition("a"));
	}

}
