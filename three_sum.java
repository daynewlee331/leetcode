package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {
	public static void main(String[] args){
		three_sum ts = new three_sum();
		int[] arr = {-1, 0, 1, 2, -1, -4};
		ts.threeSum(arr);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		for(int i = 0; i <= nums.length - 3; i ++){
			if(i - 1 >= 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates
			if(nums[i] > 0) break;
			int p = i + 1;
			int q = nums.length - 1;
			while(p < q){
				int sum = nums[i] + nums[p] + nums[q];
				if(sum == 0){
					res.add(Arrays.asList(nums[i], nums[p], nums[q]));
					p ++;
					q --;
					while(p < q && nums[p] == nums[p - 1]) p ++; //avoid duplicates
					while(p < q && nums[q] == nums[q + 1]) q --; //avoid duplicates
				}else if(sum < 0){
					p ++;
				}else{
					q --;
				}
			}
		}
		
		return res;
    }
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4) return res;
		Arrays.sort(nums);
		for(int i = 0; i <= nums.length - 4; i ++){
			if(i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
			int k = target - nums[i];
			for(int j = i + 1; j <= nums.length - 3; j ++){
				if(j - 1 >= i + 1 && nums[j - 1] == nums[j]) continue;
				int p = j + 1; int q = nums.length - 1;
				while(p < q){
					int sum = nums[j] + nums[p] + nums[q];
					if(sum == k){
						res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
						p ++;
						q --;
						while(p < q && nums[p - 1] == nums[p]) p ++;
						while(p < q && nums[q] == nums[q + 1]) q --;
					}else if(sum < k){
						p ++;
					}else{
						q --;
					}
				}
			}
		}
		return res;
	}
}
