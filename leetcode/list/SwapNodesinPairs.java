package list;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.
 * */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int count = 0;
        while (head != null) {
        	++count;
        	if (count % 2 == 0) {
        		ListNode next = head.next;
        		ListNode p = prev.next;
        		ListNode q = head;
        		
        		prev.next = q;
        		q.next = p;
        		p.next = next;
        		
        		prev = p;
        		head = p.next;
        	} else {
        		head = head.next;
        	}
        }
        return dummy.next;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode tail = new ListNode(3);
		ListNode last = new ListNode(2);
		ListNode x = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = x;
		
		
		SwapNodesinPairs s = new SwapNodesinPairs();
		ListNode p = s.swapPairs(head);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
