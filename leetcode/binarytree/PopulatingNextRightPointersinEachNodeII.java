package leetcode;
/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * */
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        TreeLinkNode next = root.next;
        while (next != null) {
        	if (next.left != null) {
        		next = next.left;
        		break;
        	}
        	if (next.right != null) {
        		next = next.right;
        		break;
        	}
        	next = next.next;
        }
        if (root.right != null)
        	root.right.next = next;
        if (root.left!= null)
        	root.left.next = root.right ==null ?next :root.right;
        connect(root.right);
        connect(root.left);
        
    }
}
