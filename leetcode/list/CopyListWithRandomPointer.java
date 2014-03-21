package list;

import java.util.HashMap;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        	return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode key = head;
        while (head != null) {
        	if (!map.containsKey(head)) {
        		RandomListNode node = new RandomListNode(head.label);
        		node.next = node.random = null;
        		map.put(head, node);
        	}
        	if (head.next != null && !map.containsKey(head.next)) {
        		RandomListNode node = new RandomListNode(head.next.label);
        		node.next = node.random = null;
        		map.put(head.next, node);
        		//map.get(head).next = node;
        	}
        	if (head.random != null && !map.containsKey(head.random)) {
        		RandomListNode node = new RandomListNode(head.random.label);
        		node.next = node.random = null;
        		map.put(head.random, node);
        		//map.get(head).random = node;
        	}
        	
        	if (head.next != null)
        		map.get(head).next = map.get(head.next);
        	if (head.random != null)
        		map.get(head).random = map.get(head.random);
        	head = head.next;
        }
        return map.get(key);
    }
}