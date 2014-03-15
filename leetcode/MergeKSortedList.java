package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * */
public class MergeKSortedList {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode root = null;
        if (lists == null || lists.size() == 0)
        	return root;
        root = new ListNode(Integer.MIN_VALUE);
        root.next = null;
        ListNode ret = root;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
        	public int compare(ListNode a, ListNode b) {
				return a.val-b.val;
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
