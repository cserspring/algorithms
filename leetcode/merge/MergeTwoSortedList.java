package merge;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of 
 * the first two lists.
 * */

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		l2.next = mergeTwoLists(l2.next, l1);
		return l2;
	}

	public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(Integer.MIN_VALUE);
		ListNode ret = root;
		root.next = null;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				root.next = l1;
				l1 = l1.next;
				root = root.next;
			} else {
				root.next = l2;
				l2 = l2.next;
				root = root.next;
			}
		}
		if (l1 != null)
			root.next = l1;
		if (l2 != null)
			root.next = l2;
		return ret.next;
	}
}
