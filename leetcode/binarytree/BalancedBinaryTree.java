package binarytree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	private int maxHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = 1 + maxHeight(root.left);
		int right = 1 + maxHeight(root.right);
		return left > right ? left : right;
	}
}
