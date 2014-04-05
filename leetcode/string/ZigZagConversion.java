package string;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

   P   A   H   N
   A P L S I I G
   Y   I   R
   And then read line by line: "PAHNAPLSIIGYIR"
   Write the code that will take a string and make this conversion given a number of rows:

   string convert(string text, int nRows);
   convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */
public class ZigZagConversion {
	/* http://fisherlei.blogspot.com/2013/01/leetcode-zigzag-conversion.html */
	public static String convertII(String s, int nRows) {
        if (nRows <= 1)
        	return s;
        String res = "";
        if (s.length() == 0)
        	return res;
        for (int i = 0; i < nRows; ++i) {
        	for (int j = 0, index = i; index < s.length(); ++j, index = (2*nRows - 2)*j +i) {
        		res += s.charAt(index);
        		if (i == 0 || i == nRows - 1)
        			continue;
        		if (index + (nRows - i - 1)*2 < s.length()) {
        			res += s.charAt(index + (nRows - i - 1)*2);
        		}
        	}
        }
        return res;
    }
	
	/* http://blog.unieagle.net/2012/11/08/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Azigzag-conversion/ */
	public static String convert(String s, int nRows) {
		if (nRows <= 1)
			return s;
		String res = "";
		int n = s.length();
		if (n == 0)
			return res;
		int zigsize = 2*nRows - 2;
		for (int i = 0; i < nRows; ++i) {
			for (int j = i; ; j += zigsize) {
				if (j >= n)
					break;
				res += s.charAt(j);
				if (i >0 && i < nRows - 1) {
					int pos = j+zigsize-2*i;
					if (pos < n)
						res += s.charAt(pos);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(convert("A", 2));
	}
}
