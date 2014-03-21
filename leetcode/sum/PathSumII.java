package sum;

import java.util.ArrayList;

//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		find(root, sum, res, oneResult);
		return res;
	}

	private void find(TreeNode root, int sum,
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> oneResult) {
		if (root == null)
			return;
		if (root.val == sum && root.left == null && root.right == null) {
			oneResult.add(root.val);
			res.add(oneResult);
			return;
		}
		oneResult.add(root.val);
		ArrayList<Integer> anotherResult1 = new ArrayList<Integer>(oneResult);
		find(root.left, sum-root.val, res, anotherResult1);
		ArrayList<Integer> anotherResult2 = new ArrayList<Integer>(oneResult);
		find(root.right, sum-root.val, res, anotherResult2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
