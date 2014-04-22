package binarytree;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		int n = num.length;
		return sortedArrayToBST(num, 0, n - 1);

	}

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
		return root;
	}
}
