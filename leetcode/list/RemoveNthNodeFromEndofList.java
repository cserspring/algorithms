package list;

public class RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
        	return head;
        
        ListNode p = head;
        ListNode q = head;
        ListNode prevq = null;
        while (p != null && n > 0) {
        	p = p.next;
        	--n;
        }
        if (p == null && n == 0)
        	return head.next;
        if (p == null && n > 0)
        	return head;
        
        while (p != null) {
        	p = p.next;
        	prevq = q;
        	q = q.next;
        }
        
        prevq.next = q.next;
        return head;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode tail = new ListNode(3);
		ListNode last = new ListNode(2);
		ListNode x = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = x;
		ListNode p = removeNthFromEnd(head, 5);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}

}
