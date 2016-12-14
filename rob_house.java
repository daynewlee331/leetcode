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
