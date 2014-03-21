package list;

public class ListInsertionSort {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// create a virtual head
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        
        ListNode prevq = head;
        ListNode q = head.next;
        ListNode prevp = root;
        ListNode p = head;
        
        while (q != null) {
        	boolean flag = false;
        	while (p != q) {
        		if (p.val >= q.val) {
        			// remove q first
        			prevq.next = q.next;
        			ListNode tmp = q.next;
        			
        			flag = true;
        			
        			prevp.next = q;
        			q.next = p;
        			
        			q = tmp;
        			break;
        		} else {
        			prevp = p;
        			p = p.next;
        		}
        	}
        	p = root.next;
        	prevp = root;
        	if (!flag) {
        		prevq = q;
        		q = q.next;
        	}
        }
        
        return root.next;
    }
	
	public static void main(String args[]) {
		ListInsertionSort sl = new ListInsertionSort();
		ListNode head = new ListNode(1);
		ListNode tail = new ListNode(2);
		ListNode last = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = null;
		ListNode res = sl.insertionSortList(head);
		System.out.println(res);
	}
}
