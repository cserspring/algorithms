package binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				res.add(node.val);
				root = node.right;
			}
		}
		return res;
	}
}
