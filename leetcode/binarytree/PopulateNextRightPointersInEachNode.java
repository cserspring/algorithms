package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 * */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulateNextRightPointersInEachNode {
	public void connectII(TreeLinkNode root) {
        if (root==null)
        	return;
        int count = 1;
        Queue<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.add(root);
        while (count > 0) {
        	while (count > 0) {
        		if (count==1) {
        			TreeLinkNode node = queue.remove();
        			node.next=null;
        			if (node.left != null) {
        				queue.add(node.left);
        				queue.add(node.right);
        			}
        			--count;
        		} else {
        			TreeLinkNode node = queue.remove();
        			node.next = queue.peek();
        			if (node.left != null) {
        				queue.add(node.left);
        				queue.add(node.right);
        			}
        			--count;
        		}
        	}
        	count = queue.size();
        }
    }
	
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null)
				root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}
