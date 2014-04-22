package binarytree;

public class ConstructBinaryTreefromInorderandPreorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		if (n == 0)
			return null;
		return buildTree(inorder, 0, n - 1, preorder, 0, n - 1);
	}

	private TreeNode buildTree(int[] inorder, int instart, int inend,
			int[] preorder, int prestart, int preend) {
		if (instart > inend)
			return null;
		int rootval = preorder[prestart];
		int rootIndex = getIndex(inorder, rootval, instart, inend);
		TreeNode root = new TreeNode(rootval);
		root.left = buildTree(inorder, instart, rootIndex - 1, preorder,
				prestart + 1, prestart + rootIndex - instart);
		root.right = buildTree(inorder, rootIndex + 1, inend, preorder,
				prestart + rootIndex - instart + 1, preend);
		return root;
	}

	private int getIndex(int[] A, int target, int start, int end) {
		for (int i = start; i <= end; ++i) {
			if (A[i] == target)
				return i;
		}
		return -1;
	}
}
