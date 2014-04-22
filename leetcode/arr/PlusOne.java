package arr;

/* 
 * Given a non-negative number represented as an array of digits, plus one to the number.

 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		int i;
		for (i = n - 1; i >= 0; --i) {
			if (digits[i] != 9) {
				++digits[i];
				return digits;
			} else {
				digits[i] = 0;
			}
		}

		int[] res = new int[n + 1];
		res[0] = 1;
		for (int j = 1; j < n + 1; ++j)
			res[j] = 0;
		return res;
	}

	/* Follow-up To return the result of (x + 1), use bitwise */
	public static int plusOne(int x) {
		/* Method 1 -> Use the - and ~ */
		// return -(~(x));

		/* Method 2 -> More formal */
		int mask = 1;
		while ((x & mask) == mask) {
			x = x ^ mask;
			mask <<= 1;
		}
		x = x ^ mask;
		return x;
	}

	public static void main(String args[]) {
		int[] digits = { 9, 9, 9 };
		int[] res = plusOne(digits);
		for (int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}
	}
}
