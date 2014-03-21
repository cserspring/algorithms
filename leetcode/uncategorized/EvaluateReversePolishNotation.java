package uncategorized;
/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
   Valid operators are +, -, *, /. Each operand may be an integer or another expression.
   Some examples:
   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * */
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; ++i) {
        	if (tokens[i].matches("[+-]?\\d+")){
        		stack.push(Integer.parseInt(tokens[i]));
        	} else {
        		int v1 = stack.pop();
        		int v2 = stack.pop();
        		
        		int ans=0;
        		
        		switch(tokens[i]) {
        		case "*":
        			ans = v1*v2;
        			break;
        		case "/":
        			ans = v2/v1;
        			break;
        		case "+":
        			ans = v1+v2;
        			break;
        		case "-":
        			ans = v2-v1;
        			break;
        		}
        		
        		stack.push(ans);
        	}
        }
        return stack.pop();
    }
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "-"};
		System.out.println(evalRPN(tokens));
	}

}
