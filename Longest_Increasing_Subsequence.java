package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Longest_Increasing_Subsequence {
	public static void main(String[] args){
		Longest_Increasing_Subsequence obj = new Longest_Increasing_Subsequence();
		obj.lengthOfLIS(new int[]{2, 5, 3, 7});
	}
	
	public int lengthOfLISOpt(int[] nums) {
		if(nums.length <= 1) return nums.length;
		List<Integer> buff = new ArrayList<Integer>();
		buff.add(nums[0]);
		for(int num : nums){
			int len = buff.size();
			int left = 0; int right = len - 1;
			while(left <= right){
				int mid = (right - left) / 2 + left;
				if(buff.get(mid) < num){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}
			if(buff.size() > left){
				buff.set(left, num);
			}else{
				buff.add(num);
			}
		}
		
		return buff.size();
	}
	
	public int lengthOfLIS(int[] nums) {
		if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i ++) dp[i] = 1;
        
        for(int i = 1; i < nums.length; i ++){
        	for(int j = 0; j < i; j ++){
        		if((nums[i] > nums[j]) && (dp[j] + 1 > dp[i])) dp[i] = dp[j] + 1;
        	}
        }
        
        int res = 0;
        for(Integer i: dp) res = Math.max(i, res);
        
        return res;
    }
}
