package leetcode;

public class longest_path_BT {
	
	public static void main(String[] args){
		
	}
	
	// leetcode 124
	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		getLongestPath(root, max);
		return max[0];
	}

	public int getLongestPath(TreeNode root, int[] max) {
		// get the sum of left subtree and right subtree separately
		// add them together with current node value to see if it's bigger than
		// current max
		if (root == null)
			return 0;
		int left = Math.max(0, getLongestPath(root.left, max));
		int right = Math.max(0, getLongestPath(root.right, max));
		max[0] = Math.max(max[0], left + right + root.val);
		return Math.max(left, right) + root.val;
	}

	// longest path in a BT, could be leaf to leaf
	public int longestPath(TreeNode root) {
		if (root == null)
			return 0;
		int left = longestPath(root.left);
		int right = longestPath(root.right);
		int across = depth(root.left) + depth(root.right) + 1;
		return Math.max(across, Math.max(right, left));
	}

	public int depth(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.max(left, right) + 1;
	}
}
