package list;

public class ListReorder {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode mid = getMid(head);
		ListNode start = mid.next;
		mid.next = null;
		ListNode secondHalf = reverse(start);
		
		ListNode p = head;
		while (p != null && secondHalf != null) {
			ListNode pNext = p.next;
			ListNode halfNext = secondHalf.next;
			p.next = secondHalf;
			secondHalf.next = pNext;
			p = pNext;
			secondHalf = halfNext;
		}
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode q = head.next;
		head.next = null;
		while (q != null) {
			ListNode node = p;
			p = q;
			q = q.next;
			p.next = node;
		}
		return p;
	}

	private ListNode getMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String args[]) {
		ListReorder sl = new ListReorder();
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		sl.reorderList(head);
		System.out.println();
	}
}
