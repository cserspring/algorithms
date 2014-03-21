package binarytree;
/* Given a binary tree, find its minimum depth.

   The minimum depth is the number of nodes along the shortest path from 
   the root node down to the nearest leaf node.
*/
public class MinHeight {
	/**
	 * Definition for binary tree public class TreeNode 
	 * { 
	 * int val; 
	 * TreeNode left; 
	 * TreeNode right; 
	 * TreeNode(int x) { val = x; } 
	 * }
	 */

	public int minDepth(TreeNode root) {
		return inMinDepth(root, false);
	}

	private int inMinDepth(TreeNode root, boolean hasBrother) {
		if (root == null)
			return hasBrother ? Integer.MAX_VALUE : 0;
		int leftH = inMinDepth(root.left, root.right != null);
		int rightH = inMinDepth(root.right, root.left != null);
		return 1 + Math.min(leftH, rightH);
	}
}
