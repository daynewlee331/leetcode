package leetcode;

public class palindrome_Linkedlist {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
        		slow = slow.next;
        		fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;//odd number of nodes
        ListNode left = head;
        ListNode right = reverseList(slow);
        while(right != null){
        		if(left.val != right.val) return false;
        		left = left.next;
        		right = right.next;
        }
        return true;
    }
	
	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
	
	public ListNode reverseList(ListNode node) {
		if(node == null) return null;
		if(node.next == null) return node;
		ListNode p2 = null;
		ListNode p1 = node;
		ListNode p3 = node.next;
		while(p1 != null){
			p1.next = p2;
			p2 = p1;
			p1 = p3;
			if(p3 == null) break;
			p3 = p3.next;
		}
		return p2;
	}
}
