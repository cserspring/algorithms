package binarytree;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		TreeNode root = null;
		ListNode prevmid = getMidPrev(head);
		if (prevmid == null) {
			root = new TreeNode(head.val);
			ListNode second = head.next;
			head.next = null;
			root.left = null;
			root.right = sortedListToBST(second);
		} else {
			root = new TreeNode(prevmid.next.val);
			ListNode second = prevmid.next.next;
			prevmid.next = null;
			root.left = sortedListToBST(head);
			root.right = sortedListToBST(second);
		}
		return root;
	}

	private ListNode getMidPrev(ListNode root) {
		if (root == null || root.next == null)
			return null;
		ListNode prevSlow = null;
		ListNode slow = root;
		ListNode fast = root;
		while (fast.next != null && fast.next.next != null) {
			prevSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return prevSlow;
	}
}
