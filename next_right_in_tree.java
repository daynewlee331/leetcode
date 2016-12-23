package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class next_right_in_tree {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// leetcode 117
	// Populating Next Right Pointers in Each Node II
	// What if the given tree could be any binary tree? Would your previous
	// solution still work?
	// 这道题本质是树的层序遍历，只是队列改成用结点自带的链表结点来维护。
	public void connect2(TreeLinkNode root) {
		TreeLinkNode head = null; // The left most node in the lower level
		TreeLinkNode prev = null; // The previous node in the lower level
		TreeLinkNode cur = root; // The current node in the upper level

		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (prev == null) {// means we are already accessing the
										// left most node of lower level.
						head = cur.left;
					} else {
						prev.next = cur.left;
					}
					prev = cur.left;
				}
				if (cur.right != null) {
					if (prev == null) {
						head = cur.right;// means we are already accessing the
											// left most node of lower level.
					} else {
						prev.next = cur.right;
					}
					prev = cur.right;
				}
				cur = cur.next;
			}
			cur = head;
			prev = null;
			head = null;
		}
	}
	
	//leetcode 116
	//Populating Next Right Pointers in Each Node
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
	
	//leetcode 199
	//Binary Tree Right Side View
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			TreeNode tmp = null;
			for(int i = 0; i < size; i ++){
				tmp = queue.poll();
				if(tmp.left != null) queue.offer(tmp.left);
				if(tmp.right != null) queue.offer(tmp.right);
			}
			res.add(tmp.val);
		}
		return res;
    }
	
}
