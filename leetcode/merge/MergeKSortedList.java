package merge;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 */
public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		int n = lists.size() - 1;
		if (n < 0)
			return null;
		while (n > 0) {
			int cur = 0;
			while (cur < n) {
				lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(n--)));
			}
		}
		return lists.get(0);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
	}

	public ListNode mergeKListsII(ArrayList<ListNode> lists) {
		ListNode root = null;
		if (lists == null || lists.size() == 0)
			return root;
		root = new ListNode(Integer.MIN_VALUE);
		root.next = null;
		ListNode ret = root;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						return a.val - b.val;
					}
				});
		for (int i = 0; i < lists.size(); ++i) {
			if (lists.get(i) != null) {
				pq.add(lists.get(i));
			}
		}

		while (pq.size() > 0) {
			ListNode node = pq.poll();
			root.next = node;
			root = root.next;
			if (node.next != null)
				pq.add(node.next);
		}
		return ret.next;
	}
}
