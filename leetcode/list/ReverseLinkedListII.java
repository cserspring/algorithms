package list;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n)
			return head;
		ListNode root = new ListNode(Integer.MIN_VALUE);
		root.next = head;
		ListNode p = root;
		ListNode q = head;
		
		ListNode start = null;
		ListNode startNext=null;
		ListNode end = null;
		ListNode endNext = null;
		int i = 1;
		while (i <= n) {
			if (i == m) {
				start = p;
				startNext = q;
				p = q;
				q = q.next;
			} else if (i==n) {
				end = q;
				endNext = q.next;
				q.next = p;
			} else if (i>m) {
				ListNode tmp = p;
				p = q;
				q = q.next;
				p.next = tmp;
			} else {
				p = p.next;
				q = q.next;
			}
			i++;
		}
		start.next = end;
		startNext.next = endNext;
		return root.next;
	}
	

	public static void main(String args[]) {
		ReverseLinkedListII sl = new ReverseLinkedListII();
		ListNode head = new ListNode(4);
		ListNode tail = new ListNode(2);
		ListNode last = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = null;
		ListNode res = sl.reverseBetween(head,1,3);
		System.out.println(res);
	}
}
