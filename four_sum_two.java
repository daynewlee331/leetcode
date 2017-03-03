package leetcode;

import java.util.HashMap;

public class four_sum_two {
	
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null || C == null || D == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i ++){
        	for(int j = 0; j < B.length; j ++){
        		int sum = A[i] + B[j];
        		if(!map.containsKey(sum)) map.put(sum, 1);
        		else map.put(sum, map.get(sum) + 1);
        	}
        }
        int res = 0;
        for(int p = 0; p < C.length; p ++){
        	for(int q = 0; q < D.length; q ++){
        		int target = 0 - (C[p] + D[q]);
        		if(map.containsKey(target)){
        			res += map.get(target);
        		}
        	}
        }
        return res;
    }
}
