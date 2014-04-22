package sum;

/*
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 * */
public class AddBinary {
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int m = a.length();
		int n = b.length();
		while (m > 0 || n > 0 || carry > 0) {
			int sum = carry;
			if (m > 0)
				sum += a.charAt(--m) - '0';
			if (n > 0)
				sum += b.charAt(--n) - '0';
			sb.insert(0, sum % 2);
			carry = sum / 2;
		}
		return sb.toString();
	}

	public static String addBinaryII(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();

		if (alen > blen) {
			return addBinary(arr1, arr2, alen, blen);
		} else {
			return addBinary(arr2, arr1, blen, alen);
		}
	}

	private static String addBinary(char[] a, char[] b, int alen, int blen) {
		int clen = alen > blen ? alen + 1 : blen + 1;
		int cclen = clen;
		int[] c = new int[clen];
		for (int i = 0; i < clen; ++i)
			c[i] = 0;
		int carry = 0;
		while (alen > 0) {
			int tmp = a[--alen] - '0' + carry;
			if (blen > 0)
				tmp += b[--blen] - '0';
			c[--clen] = tmp % 2;
			carry = tmp / 2;
		}
		c[--clen] = carry;
		StringBuilder sb = new StringBuilder();
		if (c[0] != 0)
			sb.append('1');
		for (int i = 1; i < cclen; ++i)
			sb.append((char) (c[i] + '0'));
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));
	}

}
