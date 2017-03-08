package leetcode;

import java.util.HashMap;

public class contiguous_array {
	public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        for(int i = 0; i < nums.length; i ++){
        		if(nums[i] == 0) nums[i] = -1;
        }
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i ++){
        		sum += nums[i];
        		if(map.containsKey(sum)){
        			max = Math.max(max, i - map.get(sum));
        		}else map.put(sum, i);
        }
        return max;
	}
}
