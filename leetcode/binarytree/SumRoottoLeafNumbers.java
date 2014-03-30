package binarytree;

public class SumRoottoLeafNumbers {
	private int result;
	public int sumNumbers(TreeNode root) {
        this.result = 0;
		sumHelper(root, 0);
		return this.result;
    }
	
	private void sumHelper(TreeNode root, int prev) {
		if (root == null) {
			this.result += 0;
			return;
		}
		if (root.left == null && root.right == null) {
			this.result += prev*10 + root.val;
		} else {
			sumHelper(root.left, 10*prev+root.val);
			sumHelper(root.right, 10*prev+root.val);
		}
	}
}
