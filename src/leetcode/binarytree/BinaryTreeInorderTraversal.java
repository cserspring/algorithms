package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
        	return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
        	if (!stack.isEmpty()) {
        		root = stack.peek();
            	stack.pop();
            	res.add(root.val);
            	root = root.right;
        	}
        	while (root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	
        }
        return res;
    }
}
