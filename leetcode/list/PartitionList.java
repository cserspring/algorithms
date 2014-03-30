package list;

public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		ListNode pivot = new ListNode(x);
		ListNode tmpHead = newHead;
		ListNode tmpPivot = pivot;
		ListNode p = head;

		while (p!=null) {
			if (p.val < x) {
				newHead.next = p;
				newHead = newHead.next;
			} else {
				pivot.next = p;
				pivot = pivot.next;
			}
			p = p.next;
		}
		pivot.next = null;
		newHead.next = tmpPivot.next;
		
        return tmpHead.next;
    }
	
	public static void main(String args[]) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(1);
		head.next = node1;
		ListNode ret = partition(head, 2);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}
