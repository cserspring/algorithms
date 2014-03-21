package integer;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	public static int romanToInt(String s) {
        if (s==null || s.length()==0)
        	return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int n = s.length();
        int sum = map.get(s.charAt(n-1));
        for (int i = n-2; i>=0;--i) {
        	if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
        		sum += map.get(s.charAt(i));
        	} else {
        		sum -= map.get(s.charAt(i));
        	}
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("VII"));
	}

}
