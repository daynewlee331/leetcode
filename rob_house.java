package leetcode;

import java.util.HashMap;

public class rob_house {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int rob3_opt(TreeNode root){
		int[] res = rob3_opt_helper(root);
		return Math.max(res[0], res[1]);
	}
	
	public int[] rob3_opt_helper(TreeNode root){
		if(root == null) return new int[]{0, 0};
		int[] left = rob3_opt_helper(root.left);
		int[] right = rob3_opt_helper(root.right);
		int[] res = new int[2];
		//case of skipping current node
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		//case of count current node
		res[1] = Math.max(res[0], root.val + left[0] + right[0]);
		return res;
	}
	
	
	public int rob3_naive(TreeNode root) {
		if(root == null) return 0;
		int val = 0;
		if(root.left != null){
			val += rob3_naive(root.left.left) + rob3_naive(root.left.right);
		}
		if(root.right != null){
			val += rob3_naive(root.right.left) + rob3_naive(root.right.right);
		}
		return Math.max(root.val + val, rob3_naive(root.left) + rob3_naive(root.right));
	}
	
	public int rob3_cache(TreeNode root){
		return rob3_cache_helper(root, new HashMap<TreeNode, Integer>());
	}
	
	public int rob3_cache_helper(TreeNode root, HashMap<TreeNode, Integer> map){
		if(root == null) return 0;
		if(map.containsKey(root)) return map.get(root);
		
		int val = 0;
		if(root.left != null){
			val += rob3_cache_helper(root.left.left, map) + rob3_cache_helper(root.left.right, map);
		}
		if(root.right != null){
			val += rob3_cache_helper(root.right.left, map) + rob3_cache_helper(root.right.right, map);
		}
		
		int res = Math.max(root.val + val, rob3_cache_helper(root.left, map) + rob3_cache_helper(root.right, map));
		map.put(root, res);
		return res;
	}
	
	public int rob_1(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i ++){
        	dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]); 
        }
        return dp[nums.length];
    }
	
	public int rob_2(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
		if(nums.length < 2) return nums[0];
		int[] dp1 = new int[nums.length + 1];
		int[] dp2 = new int[nums.length + 1];
		dp1[0] = 0;
		dp2[0] = 0;
		dp1[1] = nums[0];
		dp2[1] = 0;
		
		for(int i = 2; i <= nums.length; i ++){
			dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]); 
			dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], dp2[i - 1]);
		}
		return Math.max(dp1[nums.length - 1], dp2[nums.length]);
	}
	
	
}
