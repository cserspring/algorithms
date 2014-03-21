package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        return isSymmetric(root.left, root.right);
    }
	
	private boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 != null) {
			if (node1.val == node2.val) {
				return isSymmetric(node1.left, node2.right) &&
						isSymmetric(node1.right, node2.left);
			}
			return false;
		}
		return false;
	}
	
	public boolean isSymmetric_iterative(TreeNode root) {
        if (root == null)
        	return true;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
        	TreeNode node1 = q1.poll();
        	TreeNode node2 = q2.poll();
        	if (node1 == null && node2 == null) {
        		continue;
        	} else if (node1 != null && node2!=null) {
        		if (node1.val != node2.val)
        			return false;
        		else {
        			q1.add(node1.left);
        			q1.add(node1.right);
        			q2.add(node2.right);
        			q2.add(node2.left);
        		}
        	} else {
        		return false;
        	}
        	
        }
        return true;
    }
}
