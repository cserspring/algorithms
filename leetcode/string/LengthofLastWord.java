package string;

public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        boolean flag = false;
        for (int i = len-1; i >= 0; --i) {
        	if (s.charAt(i) != ' ') {
        		++count;
        		flag = true;
        	}
        	if (flag && s.charAt(i) == ' ')
        		break;
        }
        return count;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
	}

}
