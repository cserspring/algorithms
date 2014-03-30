package binarytree;

public class BinaryTreeMaximumPathSum {
    private int result;
	public int maxPathSum(TreeNode root) {
		this.result = Integer.MIN_VALUE;
        helper(root);
        return this.result;
    }
    
	private int helper(TreeNode root) {
		if (root == null)
        	return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int ret = Math.max(root.val, Math.max(root.val+left, root.val+right));
        this.result = Math.max(this.result, Math.max(ret, root.val+left+right));
        return ret;
	}
	
	public static void main(String args[]) {
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-3);
		root.left = root.right = null;
		System.out.println(b.maxPathSum(root));
	}
}
