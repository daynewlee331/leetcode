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
