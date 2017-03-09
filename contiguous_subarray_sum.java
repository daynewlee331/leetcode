package leetcode;

import java.util.HashMap;

public class contiguous_subarray_sum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        k = Math.abs(k);
        for(int i = 0; i < nums.length; i ++){
        		sum += nums[i];
        		if(k > 0) sum %= k;
        		Integer pos = map.get(sum);
        		if(pos != null){
        			if(i - pos > 1) return true;
        		}else map.put(sum, i);
        }
        return false;
    }
}
