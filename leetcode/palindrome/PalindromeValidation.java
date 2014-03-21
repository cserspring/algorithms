package palindrome;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

   For example,
   "A man, a plan, a canal: Panama" is a palindrome.
   "race a car" is not a palindrome.

   Note:
   Have you consider that the string might be empty? This is a good question to ask during an interview.

   For the purpose of this problem, we define empty string as valid palindrome.
 * */
public class PalindromeValidation {
	public static  boolean isPalindrome(String s) {
		if (s==null || s.length()==0)
			return true;
        int left = 0;
        int right = s.length()-1;
        while (left <= right) {
        	if (!isAlphanumeric(s.charAt(left)))
        		left++;
        	else if (!isAlphanumeric(s.charAt(right)))
        		right--;
        	else if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))
        		return false;
        }
        return true;
    }
	
	private static boolean isAlphanumeric(char c) {
		if ((c<='9' && c>='0') || (c<='z' && c>='a') || (c<='Z' &&c >= 'A') )
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(".,...."));
	}

}
