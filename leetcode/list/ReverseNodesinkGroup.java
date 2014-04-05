package list;
/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * */
public class ReverseNodesinkGroup {
	/* http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html */
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) 
        	return head;
        ListNode node = head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int i = 1;
        ListNode prev = dummy;
        for (node = head; node != null; node = node.next, ++i) {
        	if (i%k == 0) {
        		ListNode last = prev.next;
        		ListNode next = node.next;
        		reverse(prev, next);
        		last.next = next;
        		prev = last;
        		node = last;
        	} 
        }
        return dummy.next;
    }
	
	private void reverse(ListNode prev, ListNode next) {
		
		ListNode p = prev.next;
		ListNode q = p.next;
		p.next = null;
		//q.next = p;
		while (q != next) {
			ListNode tmp = q.next;
			q.next = p;
			p = q;
			q = tmp;
		}
		prev.next = p;
		
	}
	
	public static void main(String args[]) {
		ListNode head = new ListNode(4);
		ListNode tail = new ListNode(3);
		ListNode last = new ListNode(2);
		ListNode x = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = x;
		
		ReverseNodesinkGroup r = new ReverseNodesinkGroup();
		ListNode p = r.reverseKGroup(head, 2);
		
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
