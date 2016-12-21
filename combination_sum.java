package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class combination_sum {
	public static void main(String[] args){
		combination_sum cs = new combination_sum();
		int[] nums = {1,2,3};
		cs.combinationSum4(nums, 5);
	}
	
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
	
	//for leetcode no40:
	//Combination Sum II
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length < 1) return res;
		Arrays.sort(candidates);
		combinationSum2_helper(0, candidates, target, res, new ArrayList<Integer>());
		return res;
    }
	
	public void combinationSum2_helper(int start, int[] nums, int target
			, List<List<Integer>> res, List<Integer> cur) {
		if(target == 0) res.add(new ArrayList<Integer>(cur));
		else if(target > 0){
			for(int i = start; i < nums.length; i ++){
				if(i > start && nums[i - 1] == nums[i]) continue;//avoid duplicates
				cur.add(nums[i]);
				combinationSum2_helper(i + 1, nums, target - nums[i], res, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	//leetcode no216
	//combination sum III
	public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k < 1 || n < 0) return res;
        combinationSum3_helper(0, nums, res, new ArrayList<Integer>(), n, k);
        return res;
    }
	
	public void combinationSum3_helper(int start, int[] nums, List<List<Integer>> res
			, List<Integer> cur, int target, int k){
		if(target == 0 && cur.size() == k){
			res.add(new ArrayList<>(cur));
			return;
		}else if(target > 0 && cur.size() < k){
			for(int i = start; i < nums.length; i ++){
				cur.add(nums[i]);
				combinationSum3_helper(i + 1, nums, res, cur, target - nums[i], k);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	//leetcode 377
	//combination sum IV
	public int combinationSum4(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(nums == null || nums.length < 1 || target < 0) return 0;
		return combinationSum4_helper(nums, target, map);
	}
	
	public int combinationSum4_helper(int[] nums, int target, HashMap<Integer, Integer> map) {
		int res = 0;
		if(target < 0) return 0;
		if(target == 0) return 1;
		if(map.containsKey(target)) return map.get(target);
		for(int i = 0; i < nums.length; i ++){
			res += combinationSum4_helper(nums, target - nums[i], map);
		}
		map.put(target, res);
		return res;
	}
	
	public int myCombinationSum4(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 1) return 0;
		myCombinationSum4(nums, target, res, new ArrayList<Integer>());
		return res.size();
    }
	
	public void myCombinationSum4(int[] nums, int target, List<List<Integer>> res, List<Integer> cur){
		if(target == 0){
			res.add(new ArrayList<>(cur));
			return;
		}else if(target > 0){
			for(int i = 0; i < nums.length; i ++){
				cur.add(nums[i]);
				myCombinationSum4(nums, target - nums[i], res, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
