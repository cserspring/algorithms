package list;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*
  We assume the loop has n nodes. When 'slow' pointer gets to the start of the loop, 
  we assume it is k steps from the 'head'. Now we know 'fast' pointer has moved 2k steps. 
  When will they meet?
    x % n == (k+2x) % n, 

    x/n = x1;
    x%n = y1;

    (k+2x)/n = x2;
    (k+2x)%n = y1;

    x = n*x1 + y1
    k+2x = n*x2 + y1

    x  = (x2-x1)n - k

    so we can get x = c*n-k, c is an integer.
  */
public class DetectCycleStart {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}