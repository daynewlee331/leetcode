package leetcode;

import java.util.ArrayList;

public class Flatten_BT_to_LinkedList {
	//leetcode 114
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		Flatten_BT_to_LinkedList sol = new Flatten_BT_to_LinkedList();
		sol.flatten(root);
	}
	
	public void flatten(TreeNode root) {
		ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
		prev.add(new TreeNode(-1));
		helper(root, prev);
    }
	
	public void helper(TreeNode root, ArrayList<TreeNode> prev){
		if(root == null) return;
		TreeNode right = root.right;
		if(prev != null){
			prev.get(0).right = root;
			prev.get(0).left = null;
		}
		prev.set(0, root);
		helper(root.left, prev);
		helper(right, prev);
	}
	
	public void flatten2(TreeNode root) {
		TreeNode[] prev = new TreeNode[1];
		prev[0] = new TreeNode(-1);
		helper2(root, prev);
	}
	
	public void helper2(TreeNode root, TreeNode[] prev){
		if(root == null) return;
		TreeNode right = root.right;
		if(prev != null){
			prev[0].right = root;
			prev[0].left = null;
		}
		prev[0] = root;
		helper2(root.left, prev);
		helper2(right, prev);
	}
}
