package arr;

import java.util.Arrays;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

   Note: The numbers can be arbitrarily large and are non-negative.
 * */
public class MultiplyStrings {
	/* Test case: 0, 0 */
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int sum = len1 + len2;
		int[] result = new int[sum];
		Arrays.fill(result, 0);

		for (int i = len1 - 1; i >= 0; --i) {
			int carry = 0;
			int val1 = num1.charAt(i) - '0';
			for (int j = len2 - 1; j >= 0; --j) {
				int val2 = num2.charAt(j) - '0';
				result[i + j + 1] += carry + val1 * val2;
				carry = result[i + j + 1] / 10;
				result[i + j + 1] %= 10;
			}
			result[i] += carry;
		}
		int i = 0;
		while (i < sum - 1 && result[i] == 0)
			i++;
		StringBuilder sb = new StringBuilder();
		for (; i < sum; ++i)
			sb.append((char) ('0' + result[i]));
		return sb.toString();
	}
	
	public static String multiplyII(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int sum = len1 + len2;
        
        int[] res = new int[sum];
        for (int i = 0; i < sum; ++i)
        	res[i] = 0;
        
        for (int i = 0; i < len1; ++i) {
        	int carry = 0;
        	int a = num1.charAt(len1 - 1 - i) - '0';
        	for (int j = 0; j < len2; ++j) {
        		int b = num2.charAt(len2 - 1 - j) - '0';
        		res[i+j] += carry+a*b;
        		carry = res[i+j]/10;
        		res[i+j] %= 10;
        	}
        	res[i+len2] += carry;
        }
        
        while (res[sum-1] == 0)
        	sum--;
        StringBuilder sb = new StringBuilder();
        for (int i = sum - 1; i>=0;--i)
        	sb.append(res[i]);
        
        return sb.toString();
    }
	public static String multiplyI(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int sum = len1 + len2;
        char[] res = new char[sum];
        
        for (int i = 0; i < sum; ++i) res[i] = '0';
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        reverse(s1);
        reverse(s2);
        for (int i = 0; i < len1; ++i) {
        	int val1 = s1[i]-'0';
        	int carry = 0;
        	for (int j = 0; j < len2; ++j) {
        		int val2 = s2[j] - '0';
        		int exist = res[i+j] - '0';
        		int ans = val1*val2+carry+exist;
        		carry = ans/10;
        		res[i+j] = (char) ((char) (ans%10)+ '0');
        	}
        	if(carry >0) {
        		res[i+len2] += carry;
        	}
        }
        reverse(res);
        String result = String.valueOf(res);
        int index = 0;
        for (int i = 0; i < res.length; ++i) {
        	if (res[i] != '0'){
        		index=i;
        		break;
        	}
        }
        return result.substring(index);
    }
	
	private static void reverse(char[] s) {
		for (int i = 0; i < s.length/2; ++i) {
			char tmp = s[i];
			s[i] = s[s.length-1-i];
			s[s.length-1-i] = tmp;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("999", "99"));
	}
}
