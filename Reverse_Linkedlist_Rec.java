package leetcode;

public class Reverse_Linkedlist_Rec {
	public static void main(String[] args){
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		Reverse_Linkedlist_Rec sol = new Reverse_Linkedlist_Rec();
		sol.reverseLinkedlist(node);
		ListNode cur = sol.prev;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	ListNode prev = null;
	public void reverseLinkedlist(ListNode node){
		if(node == null) return;
		ListNode tmp = node.next;
		node.next = prev;
		prev = node;
		reverseLinkedlist(tmp);
	}
}
