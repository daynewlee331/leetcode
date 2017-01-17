package leetcode;

public class longest_path_BT {
	//longest path in a BT, could be leaf to leaf
	public int longestPath(TreeNode root){
		if(root == null) return 0;
		int left = longestPath(root.left);
		int right = longestPath(root.right);
		int across = depth(root.left) + depth(root.right) + 1;
		return Math.max(across, Math.max(right, left));
	}
	
	public int depth(TreeNode root){
		if(root == null) return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.max(left, right) + 1;
	}
}
