package binarytree;

public class FlattenBinaryTreetoLinkedList {

	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.left);
		flatten(root.right);
		TreeNode right = root.right;
		// If root.left == null, we just do the above
		if (root.left != null) {
			root.right = root.left;
			root.left = null;

			TreeNode rightMost = root.right;
			if (rightMost != null) {
				while (rightMost.right != null)
					rightMost = rightMost.right;
				rightMost.right = right;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode child = new TreeNode(2);
		child.left = child.right = null;
		root.right = child;
		flatten(root);
	}

}
