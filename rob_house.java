package leetcode;

public class rob_house {
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
}
