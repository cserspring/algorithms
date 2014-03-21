package leetcode;
/*
 * Given an input string, reverse the string word by word.

   For example,
   Given s = "the sky is blue",
   return "blue is sky the".
 * */

public class ReverseWordsinaString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0)
        	return s;
        String[] arr = s.split("\\s+");
        for (int i = 0; i < arr.length/2; ++i) {
        	String tmp = arr[i];
        	arr[i] = arr[arr.length-1-i];
        	arr[arr.length-1-i] = tmp;
        }
        String result = "";
        for (int i = 0; i < arr.length; ++i)
        	result += arr[i] + " ";
        return result.trim();
    }
}
