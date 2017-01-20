package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class top_k_frequent_elements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n: nums){
			if(!map.containsKey(n)){
				map.put(n, 1);
			}else{
				int num = map.get(n);
				map.put(n, num + 1);
			}
		}
		
		for(int key: map.keySet()){
			if(bucket[map.get(key)] == null){
				bucket[map.get(key)] = new ArrayList<Integer>();
			}
			bucket[map.get(key)].add(key);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for(int i = bucket.length - 1; i >= 0 && res.size() < k; i --){
			if(bucket[i] != null) res.addAll(bucket[i]);
		}
		return res;
    }
}
