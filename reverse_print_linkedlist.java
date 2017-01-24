package leetcode;

public class reverse_print_linkedlist {
	public static void main(String[] args){
		reverse_print_linkedlist sol = new reverse_print_linkedlist();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		sol.printElement(head);
	}
	
	public void printElement(ListNode node){
		if(node == null) return;
		printElement(node.next);
		System.out.print(node.val + " ");
	}
}
