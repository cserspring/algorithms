package palindrome;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.

   click to show spoilers.

   Some hints:
   Could negative integers be palindromes? (ie, -1)

   If you are thinking of converting the integer to string, note the restriction of using extra space.

   You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
   you know that the reversed integer might overflow. How would you handle such case?

   There is a more generic way of solving this problem.
 * */
public class PalindromeNumber {
	public static  boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int cx = x;
		int ans;
		int rem;
		int a=1;
		while ((cx = cx/10) != 0) {
			a *=10;
		}
		
		while(x>0) {
			ans = x/a;
			rem = x%10;
			if (ans != rem)
				return false;
			x = (x-ans*a)/10;
			a = a/100;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(0));
	}

}
