package list;
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 * */
public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode newHead = new ListNode(0);
        ListNode tmpHead = newHead;

        ListNode q = head;
        while (head != null) {
        	while (q.next != null && q.next.val == head.val)
        		q = q.next;
        	if (head == q) {
        		newHead.next = head;
        		newHead = newHead.next;
        		
        	} 
        	head = q.next;
    		q = q.next;
        }
        newHead.next = null;
        return tmpHead.next;
    }
	
	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		head.next = node1;
		node1.next = node2;
		ListNode ret = deleteDuplicates(head);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}
