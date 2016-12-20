package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length < 1) return res;
		Arrays.sort(candidates);
		combinationSum_helper(0, res, new ArrayList<Integer>(), target, candidates);
		return res;
    }
	
	public void combinationSum_helper(int start, List<List<Integer>> res
			, List<Integer> cur, int remain, int[] nums){
		if(remain == 0) res.add(new ArrayList<Integer>(cur));	
		else if(remain > 0){
			for(int i = start; i < nums.length; i ++){
				cur.add(nums[i]);
				combinationSum_helper(i, res, cur, remain - nums[i], nums);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
