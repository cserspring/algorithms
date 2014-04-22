package list;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
	/*
	 * Test case: {0} {0} {5} {5} {1} {1}
	 */
	/* Iterative */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int carry = 0;
		ListNode head = dummy;
		do {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			ListNode node = new ListNode(sum);
			head.next = node;
			head = node;
		} while (l1 != null || l2 != null || carry > 0);

		return dummy.next;
	}

	/* Recursive */
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
		int carry = 0;
		return addTwoNumbersII(l1, l2, carry);
	}

	private ListNode addTwoNumbersII(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			if (carry != 0)
				return new ListNode(carry);
			return null;
		}

		ListNode node = new ListNode(0);
		if (l1 != null) {
			node.val += l1.val;
			l1 = l1.next;
		}
		if (l2 != null) {
			node.val += l2.val;
			l2 = l2.next;
		}
		node.val += carry;

		carry = node.val / 10;
		node.val = node.val % 10;

		node.next = addTwoNumbersII(l1, l2, carry);
		return node;
	}

	public ListNode addTwoNumbersIII(ListNode l1, ListNode l2) {
		int carry = 0;
		return addTwoNumbersIII(l1, l2, carry);
	}

	private ListNode addTwoNumbersIII(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			if (carry == 0)
				return null;
			ListNode p = new ListNode(carry);
			return p;
		}
		int sum = 0;
		if (l1 != null && l2 != null) {
			sum += l1.val + l2.val + carry;
			l1.val = sum % 10;
			carry = sum / 10;
			l1.next = addTwoNumbersIII(l1.next, l2.next, carry);
			return l1;
		}

		ListNode p = l1 != null ? l1 : l2;
		sum += p.val + carry;
		p.val = sum % 10;
		carry = sum / 10;
		p.next = addTwoNumbersIII(null, p.next, carry);
		return p;
	}
}
