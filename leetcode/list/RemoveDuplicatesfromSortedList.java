package list;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head ==null)
			return null;
		ListNode p = head;
		ListNode q = p.next;
		while (q != null) {
			if (q.val != p.val) {
				p=p.next;
				q=q.next;
			} else {
				q=q.next;
				p.next = q;
			}
		}
		return head;
	}
}
