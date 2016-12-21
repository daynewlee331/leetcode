package leetcode;

public class next_right_in_tree {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	//hint:
	//always begin from the most left node
	//connecting children nodes (nodes of lower level) 
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left != null){
        	cur = pre;
        	while(cur != null){
        		cur.left.next = cur.right;
        		if(cur.next != null) cur.right.next = cur.next.left;
        		cur = cur.next;
        	}
        	pre = pre.left;
        }
    }
}