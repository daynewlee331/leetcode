package leetcode;

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
}
