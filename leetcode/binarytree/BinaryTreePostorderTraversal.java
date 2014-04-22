package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}

		while (!stack2.isEmpty()) {
			TreeNode node = stack2.pop();
			res.add(node.val);
		}

		return res;
	}

	public ArrayList<Integer> postorderTraversalII(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null)
					stack.push(cur.left);
				else if (cur.right != null)
					stack.push(cur.right);
			} else if (cur.left == prev) {
				if (cur.right != null)
					stack.push(cur.right);
			} else {
				res.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}

		return res;
	}
}
