package leetcode;

public class max_product_subarr {
	//leetcode 152 Maximum Product Subarray
	public int maxProduct(int[] nums) {
		if(nums == null || nums.length < 1) return 0;
		int res = nums[0];
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
        	max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        	min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        	res = Math.max(max[i], res);
         }
        
        return res;
    }
}
