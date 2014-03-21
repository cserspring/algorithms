package list;

public class ListMergeSort {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
        ListNode mid = getMid(head);
        ListNode secondStart = mid.next;
        // Set mid.next to be null
        mid.next = null;
        
        return merge(sortList(head), sortList(secondStart));
    }
	
	private ListNode merge(ListNode a, ListNode b) {
		ListNode root = new ListNode(Integer.MIN_VALUE);
		ListNode ret = root;
		root.next = null;
		while (a != null && b != null) {
			if (a.val < b.val) {
				root.next = a;
				a = a.next;
				root = root.next;
			} else {
				root.next = b;
				b = b.next;
				root = root.next;
			}
		}
		if (a != null) 
			root.next = a;
		if (b != null)
			root.next = b;
		return ret.next;
	}
	
	private ListNode getMid(ListNode root) {
		if (root == null)
			return null;
		ListNode slow = root;
		ListNode fast = root;
		// Here, fast.next and fast.next.next
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String args[]) {
		ListMergeSort sl = new ListMergeSort();
		ListNode head = new ListNode(4);
		ListNode tail = new ListNode(2);
		ListNode last = new ListNode(1);
		head.next = tail;
		tail.next = last;
		last.next = null;
		ListNode res = sl.sortList(head);
		System.out.println(res);
	}
}
