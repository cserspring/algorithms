package binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		zigzagLevelOrder(res, root, 0);
		for (int i = 0; i < res.size(); ++i) {
			if (i % 2 == 1) {
				Collections.reverse(res.get(i));
			}
		}
		return res;
    }
	
	private void zigzagLevelOrder(ArrayList<ArrayList<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() <= level) {
			ArrayList<Integer> oneLevel = new ArrayList<Integer>();
			oneLevel.add(root.val);
			res.add(oneLevel);
		} else {
			res.get(level).add(root.val);
		}
		zigzagLevelOrder(res, root.left, level+1);
		zigzagLevelOrder(res, root.right, level+1);
	}
}
