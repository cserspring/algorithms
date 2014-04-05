package recursive;

import java.util.ArrayList;

public class GenerateParentheses {
	// Use array
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
        char[] oneResult = new char[2*n];
        int index = 0;
        addResult(res, oneResult, n, n, index);
        return res;
    }
	
	private static void addResult(ArrayList<String> res, char[] oneResult, int l, int r, int index) {
		if (l < 0 || l > r)
			return;
		if (l==0 && r==0) {
			res.add(String.valueOf(oneResult));
			return;
		}
		if (l > 0) {
			oneResult[index] = '(';
			addResult(res, oneResult, l-1, r, index+1);
		}
		if (l <= r) {
			oneResult[index] = ')';
			addResult(res, oneResult, l, r-1, index+1);
		}
	}
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

}
