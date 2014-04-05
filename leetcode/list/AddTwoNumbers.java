package list;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		return addTwoNumbers(l1, l2, carry);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
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
			l1.next = addTwoNumbers(l1.next, l2.next, carry);
			return l1;
		}

		ListNode p = l1 != null ? l1 : l2;
		sum += p.val + carry;
		p.val = sum % 10;
		carry = sum / 10;
		p.next = addTwoNumbers(null, p.next, carry);
		return p;
	}

	public static void main(String[] args) {

	}
}
