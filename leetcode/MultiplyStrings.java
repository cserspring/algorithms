package tst;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
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
System.out.println(multiply("999", "999"));
	}

}
