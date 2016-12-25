package leetcode;

public class rotate_list {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	//leetcode 61. Rotate List
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) return null;
        ListNode copy = head;
        int length = 1;
        while(copy.next != null){
        	copy = copy.next;
        	length ++;
        }
        copy.next = head;
        int j = 1;
        ListNode cur = head;
        while(j < length - k % length){
        	 cur = cur.next;
        	 j ++;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
