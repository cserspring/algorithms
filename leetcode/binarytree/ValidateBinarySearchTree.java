package binarytree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean isValidBST(TreeNode root, int leftLimit, int rightLimit) {
		if (root == null)
			return true;
		boolean flag = root.val <rightLimit && root.val > leftLimit;
		return flag && isValidBST(root.left, leftLimit, root.val) && 
				isValidBST(root.right, root.val, rightLimit);
	}
}
