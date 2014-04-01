package uncategorized;
/*
 * Given an absolute path for a file (Unix-style), simplify it.

   For example,
   path = "/home/", => "/home"
   path = "/a/./b/../../c/", => "/c"
   click to show corner cases.

   Corner Cases:
   Did you consider the case where path = "/../"?
   In this case, you should return "/".
   Another corner case is the path might contain multiple slashes '/' together, 
   such as "/home//foo/".
   In this case, you should ignore redundant slashes and return "/home/foo".
 * */
import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] arr = path.split("/");
		if (arr.length == 0)
			return "/";
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].equals("") || arr[i].equals(".")) {
				
			} else if (arr[i].equals("..")) {
				if (!stack.empty())
					stack.pop();
			} else {
				stack.push(arr[i]);
			}
		}
		if (stack.isEmpty())
			return "/";
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.peek());
			
			stack.pop();
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(simplifyPath("/abc/..."));
	}

}
