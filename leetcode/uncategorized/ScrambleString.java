package uncategorized;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int len2 = s2.length();
        if (len != len2)
        	return false;
        char[] c = new char[26];
        for (int i = 0; i < 26; ++i)
        	c[i] = 0;
        for (int i = 0; i < len; ++i) {
        	c[s1.charAt(i)-'a']++;
        	c[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; ++i) {
        	if (c[i] != 0)
        		return false;
        }
        if (len==1)
        	return true;
        
        for (int i = 0; i < len-1; ++i) {
        	boolean flag = isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && 
        			isScramble(s1.substring(i+1, len), s2.substring(i+1, len));
        	flag = flag || (isScramble(s1.substring(0, i+1), s2.substring(len-i-1, len)) && 
        			isScramble(s1.substring(i+1, len), s2.substring(0, len-i-1)));
        	if (flag)
        		return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("great", "rgtae"));
	}

}
