package leetcode;

import java.util.Stack;

public class sortedArr_to_BST {
	//leetcode 108
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
	
	public TreeNode helper(int[] nums, int l, int r){
		if(r < l) return null;
		int mid = (r - l) / 2 + l;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, l, mid - 1);
		node.right = helper(nums, mid + 1, r);
		return node;
	}
	
	public TreeNode sortedArrayToBSTIte(int[] nums) {
		if(nums == null || nums.length < 1) return null;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> leftIndexStack = new Stack<Integer>();
		Stack<Integer> rightIndexStack = new Stack<Integer>();
		
		TreeNode head = new TreeNode(0);
		leftIndexStack.push(0); 
		rightIndexStack.push(nums.length - 1);
		nodeStack.push(head);
		
		while(!nodeStack.isEmpty()){
			TreeNode cur = nodeStack.pop();
			int left = leftIndexStack.pop(); 
			int right = rightIndexStack.pop();
			
			int mid = (right - left) / 2 + left;
			cur.val = nums[mid];
			if(left <= mid - 1){
				cur.left = new TreeNode(0);
				nodeStack.push(cur.left);
				leftIndexStack.push(left); 
				rightIndexStack.push(mid - 1);
			}
			if(mid + 1 <= right ){
				cur.right = new TreeNode(0);
				nodeStack.push(cur.right);
				leftIndexStack.push(mid + 1); 
				rightIndexStack.push(right);
			}
		}
		return head;
	}
	
}
