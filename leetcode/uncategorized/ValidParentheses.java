package uncategorized;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {

		if (s == null || s.length() % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<Character>();
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (stack.isEmpty()) {
				return false;
			} else {
				if (c == ')') {
					char cc = stack.peek();
					if (cc == '(')
						stack.pop();
					else
						return false;
				} else if (c == ']') {
					char cc = stack.peek();
					if (cc == '[')
						stack.pop();
					else
						return false;
				} else if (c == '}') {
					char cc = stack.peek();
					if (cc == '{')
						stack.pop();
					else
						return false;
				}
			}

		}
		return stack.isEmpty();
	}
}
