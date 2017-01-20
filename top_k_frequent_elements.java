package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.w3c.dom.Element;

public class top_k_frequent_elements {
	class Element{
		int val;
		int frequence;
		public Element(int val, int fre){
			this.val = val;
			this.frequence = fre;
		}
	}
	
	//1, 1, 1, 2, 2, 3
	//1 -> [1,3]
	//2 -> [2, 2]
	//3 -> [3, 1]
	
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
