package leetcode;

import java.util.Stack;

public class reverse_print_linkedlist {
	public static void main(String[] args){
		reverse_print_linkedlist sol = new reverse_print_linkedlist();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		sol.reversePrint(head);
	}
	
	public void printElement(ListNode node){
		if(node == null) return;
		printElement(node.next);
		System.out.print(node.val + " ");
	}
	
	public void reversePrint(ListNode node){
		if(node == null) return;
		Stack<ListNode> stack = new Stack<ListNode>();
		while(node != null){
			stack.add(node);
			node = node.next;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().val + " ");
		}
	}
}
