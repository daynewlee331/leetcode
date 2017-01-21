package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class intersection_two_arr {
	public static void main(String[] args){
		intersection_two_arr sol = new intersection_two_arr();
		sol.intersection(new int[]{2,4,6,8,11,9}, new int[]{7,11,9,1,3,5});
	}
	
	public int[] intersection2(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) return new int[0];
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> buff = new HashSet<>();
        for(int num : nums1){
        	set.add(num);
        }
        for(int num: nums2){
        	if(set.contains(num)) buff.add(num);
        }
        
        int[] res = new int[buff.size()];
        int k = 0;
        for(int num: buff){
        	res[k] = num;
        	k ++;
        }
        return res;
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0;
        HashSet<Integer> buff = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
        	if(i < nums1.length && j < nums2.length){
        		if(nums1[i] < nums2[j]) i ++;
            	else if(nums1[i] == nums2[j]) {
            		buff.add(nums1[i]);
            		i ++;
            		j ++;
            	}
            	else if(nums1[i] > nums2[j]) j ++;
        	}
        }
        
        int[] res = new int[buff.size()];
        int k = 0;
        for(int num: buff){
        	res[k] = num;
        	k ++;
        }
        return res;
    }
}
