package binarytree;
/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
 * */
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		getLevelResult(res, root, 0);
		for (int i = 0; i < res.size()/2; ++i) {
			ArrayList<Integer> tmp = res.get(i);
			res.set(i, res.get(res.size()-1-i));
			res.set(res.size()-1-i, tmp);
		}
		return res;
    }
	
	private void getLevelResult(ArrayList<ArrayList<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() <= level) {
			ArrayList<Integer> subRes = new ArrayList<Integer>();
			subRes.add(root.val);
			res.add(subRes);
		} else {
			res.get(level).add(root.val);
		}
		getLevelResult(res, root.left, level+1);
		getLevelResult(res, root.right, level+1);
	}
}
