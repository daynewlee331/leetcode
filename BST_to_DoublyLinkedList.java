package leetcode;

public class BST_to_DoublyLinkedList {
	
	private TreeNode lastNode;
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		BST_to_DoublyLinkedList sol = new BST_to_DoublyLinkedList();
		TreeNode head = sol.BST2DoublyLinkedlist(root);
		while ( head != null ){
            System.out.print(head.val + "->");
            head = head.right;
        }
	}
	
	public TreeNode BST2DoublyLinkedlist(TreeNode root){
		if(root == null) return null;
		TreeNode fakeHead = new TreeNode(-1);
		this.lastNode = fakeHead;
		helper(root);
		return fakeHead.right;
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
