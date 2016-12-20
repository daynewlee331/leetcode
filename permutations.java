package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 1) return res;
        Arrays.sort(nums);
        permute_helper(nums, res, new ArrayList<Integer>());
        return res;
    }
	
	
	public void permute_helper(int[] nums, List<List<Integer>> res, List<Integer> cur) {
		if(cur.size() == nums.length){
			res.add(new ArrayList<>(cur));
		}else if(cur.size() < nums.length){
			for(int i = 0; i < nums.length; i ++){
				if(cur.contains(nums[i])) continue;
				cur.add(nums[i]);
				permute_helper(nums, res, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
}
