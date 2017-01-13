package leetcode;

public class BST_to_DoublyLinkedList {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private TreeNode lastNode;
	
	public TreeNode BST2DoublyLinkedlist(TreeNode root){
		if(root == null) return null;
		TreeNode fakeHead = new TreeNode(-1);
		this.lastNode = fakeHead;
		helper(root);
		return this.lastNode.right;
	}
	
	public void helper(TreeNode root){
		if(root == null) return;
		helper(root.left);
		root.left = lastNode;
		lastNode.right = root;
		lastNode = root;
		helper(root.right);
	}
}
