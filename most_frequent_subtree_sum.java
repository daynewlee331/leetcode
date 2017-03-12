package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class most_frequent_subtree_sum {
	public static void main(String[] args){
		System.out.println(true&&true&&false);
	}
	
	int[] max = {0};
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null) return new int[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		getSum(root, map);
		List<Integer> res = new ArrayList<>();
		for(int k: map.keySet()){
			if(map.get(k) == max[0]){
				res.add(k);
			}
		}
		
		int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
		return result;
    }
	
	public int getSum(TreeNode root, HashMap<Integer, Integer> map){
		if(root == null && root == null) return 0;
		int left = getSum(root.left, map);
		int right = getSum(root.right, map);
		int sum = left + right + root.val;
		
		if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
		else map.put(sum, 1);
		max[0] = Math.max(max[0], map.get(sum));
		
		return sum;
	}
}
