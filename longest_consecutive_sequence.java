package leetcode;

import java.util.HashSet;

//leetcode 128. Longest Consecutive Sequence
public class longest_consecutive_sequence {
	public static void main(String[] args){
		int[] test = {2,1,4,6,5,3};
		longest_consecutive_sequence lcs = new longest_consecutive_sequence();
		int size = lcs.longestConsecutive(test);
		System.out.println(size);
	}
	
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num: nums) set.add(num);
		int res = 0;
		for(int i = 0; i < nums.length; i ++){
			int cur = nums[i] - 1;
			int count = 1;
			while(set.contains(cur)){
				count ++;
				set.remove(cur);
				cur --;
			}
			
			cur = nums[i] + 1;
			while(set.contains(cur)){
				count ++;
				set.remove(cur);
				cur ++;
			}
			res = Math.max(res, count);
		}
		return res;
    }
}
