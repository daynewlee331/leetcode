package leetcode;

public class swap_nodes {
	
	public static void main(String[] args){
		swap_nodes sn = new swap_nodes();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		sn.reverseKGroup(head, 3);
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
	
	//leetcode 25. Reverse Nodes in k-Group
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k){//find k+1 th node
        	curr = curr.next;
        	count ++;
        }
        if(count == k){
        	curr = reverseKGroup(curr, k);
        	while(count > 0){
        		ListNode tmp = head.next;
        		head.next = curr;
        		curr = head;
        		head = tmp;
        		count --;
        	}
        	head = curr;
        }
        return head;
    }
}
