package leetcode;

public class swap_nodes {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
		swapHelper(head);
		return head;
    }
	
	public void swapHelper(ListNode node){
		if(node == null) return;
		if(node.next == null) return;
		ListNode next = node.next;
		int buff = next.val;
		next.val = node.val;
		node.val = buff;
		swapHelper(node.next.next);
	}
}
