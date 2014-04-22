package binarytree;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		if (n == 0)
			return null;
		return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
	}

	private TreeNode buildTree(int[] inorder, int instart, int inend,
			int[] postorder, int poststart, int postend) {
		if (instart > inend)
			return null;
		int rootval = postorder[postend];
		int rootIndex = getIndex(inorder, rootval, instart, inend);
		TreeNode root = new TreeNode(rootval);
		root.left = buildTree(inorder, instart, rootIndex - 1, postorder,
				poststart, poststart + rootIndex - 1 - instart);
		root.right = buildTree(inorder, rootIndex + 1, inend, postorder,
				poststart + rootIndex - instart, postend - 1);
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
