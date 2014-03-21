package binarytree;

public class RecoveryBinarySearchTree {
	private TreeNode tn1;
	private TreeNode tn2;
	private TreeNode prev;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		tn1 = tn2 = prev = null;
		inorder(root);
		if (tn1 != null && tn2 != null) {
			int tmp = tn1.val;
			tn1.val = tn2.val;
			tn2.val = tmp;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null) {
			if (prev.val > root.val) {
				if (tn1 == null) {
					tn1 = prev;
					tn2 = root;
				} else {
					tn2 = root;
				}
			}
		}
		prev = root;
		inorder(root.right);
	}
}
