package binarytree;

import java.util.ArrayList;

public class NumOfBSTPrint {
	public ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> roots = generateTreesHelper(1, n);
		return roots;
	}

	private ArrayList<TreeNode> generateTreesHelper(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		// Be careful here, you need to add null to the res list.
		if (start > end) {
			res.add(null);
			return res;
		}
		int i;
		ArrayList<TreeNode> leftTrees;// = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightTrees;// = new ArrayList<TreeNode>();

		for (i = start; i <= end; ++i) {
			leftTrees = generateTreesHelper(start, i - 1);
			rightTrees = generateTreesHelper(i + 1, end);
			for (int j = 0; j < leftTrees.size(); ++j) {
				for (int k = 0; k < rightTrees.size(); ++k) {
					TreeNode root = new TreeNode(i);
					root.left = leftTrees.get(j);
					root.right = rightTrees.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}