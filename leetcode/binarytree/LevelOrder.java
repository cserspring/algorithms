package binarytree;
/* Binary Tree Level Order Traversal */

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		traverse(root, 0, res);
		return res;
	}

	private void traverse(TreeNode root, int level,
			ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return;
		if (res.size() <= level) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			res.add(newList);
		}
		res.get(level).add(root.val);
		traverse(root.left, level + 1, res);
		traverse(root.right, level + 1, res);
	}
}
