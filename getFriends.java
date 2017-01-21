package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class getFriends {
	public List<Character> findSameFriends(String A, String B){
		List<Character> res = new ArrayList<Character>();
		if(A == null || A.length() < 1 || B == null || B.length() < 1) return res;
		HashSet<Character> set = new HashSet<Character>();
		char[] arr1 = A.toCharArray();
		char[] arr2 = B.toCharArray();
		for(char c: arr1){
			set.add(c);
		}
		
		for(char c: arr2){
			if(set.contains(c)) res.add(c);
		}
		return res;
	}
	
	public int[] getFriends(int id){
		return null;
	}
	
	public List<Integer> findCommonFriend(int id){
		List<Integer> res = new ArrayList<Integer>();
		int[] friends = getFriends(id);
		for(int friend: friends){
			int[] candidates = getFriends(friend);
			for(int candidate: candidates){
				res.add(candidate);
			}
		}
		return res;
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length < 1 || k < 1) return res;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer>[] buckets  = new List[nums.length];
		for(int num: nums){
			if(map.containsKey(num)){
				int tmp = map.get(num);
				map.put(num, tmp + 1);
			}else{
				map.put(num, 0);
			}
		}
		
		for(int num: map.keySet()){
			int index = map.get(num);
			if(buckets[index] == null) buckets[index] = new ArrayList<Integer>();
			buckets[index].add(num);
		}
		
		for(int i = buckets.length - 1; i >= 0 && res.size() < k; i --){
			if(buckets[i] != null)res.addAll(buckets[i]);
		}
		
		return res;
	}
}
