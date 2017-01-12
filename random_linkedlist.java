package leetcode;

import java.util.HashMap;

public class random_linkedlist {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = head;
		while(cur != null){
			map.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}
		
		cur = head;
		RandomListNode node = map.get(head);
		while(cur != null){
			node.next = map.get(cur.next);
			node.random = map.get(cur.random);
			cur = cur.next;
			node = node.next;
		}
		return map.get(head);
	}
}
