package list;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return head;
        ListNode p = head;
        ListNode q = head;
        int count = 0;
        while (p != null) {
        	p = p.next;
        	count++;
        }
        n = n%count;
        p = head;
        if (n==0)
        	return head;
        while (q != null && n > 0) {
        	q = q.next;
        	n--;
        }
        
        while (q.next != null) {
        	p = p.next;
        	q = q.next;
        }
        
        ListNode newhead = p.next;
        q.next = head;
        p.next = null;
        return newhead;
    }
}
