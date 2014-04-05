package uncategorized;

import java.util.Stack;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int last = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i-last);
					} else {
						max = Math.max(max, i-stack.peek());
					}
				}
			}
		}
		return max;
    }
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()()"));
	}

}
