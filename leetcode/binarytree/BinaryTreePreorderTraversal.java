package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			res.add(node.val);
			stack.pop();
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return res;
	}
}
