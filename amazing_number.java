package leetcode;

import java.util.ArrayList;

public class amazing_number {
	
	public static void main(String[] args){
		int[] arr = {4,2,8,2,4,5,3};
		amazing_number obj = new amazing_number();
		obj.amazingNumbers(arr);
		//System.out.println(index);
	}
	/*
	 * index: 0, 1, 2, 3, 4, 5, 6, 
	 * value: 4, 2, 8, 2, 4, 5, 3, 
	 * n = 7
	 * value 4 at index 0: can be used if start index is between 1 and 3
	 * becaue there must be at least 4 elements before a[0] to satisfy a[0] >= index.	 
	 * that is 0 + 1 .. n + 0 - a[0]
	 * value 2 at index 1: can be used if start index is between 2 and 6
	 * that is 1 + 1 .. n + 1 - a[1]
	 * value 8 at index 2 can never be used because 8>n
	 * that is 2 + 1 .. n + 2 - a[2] => 3 .. 1 (which is not an interval)
	 */
	
	public int amazingNumbers(int[] a){
		int len = a.length;
		int[] count = new int[len];
		for(int i = 0; i < len; i ++){
			if(a[i] >= len) continue;
			int start = (i + 1) % len;
			int end = (len + (i - a[i])) % len;
			count[start] ++;
			if(end + 1 < len) count[end + 1] --;
		}
		
		//"start" means at that year one person's born, so total ++
		//"end + 1" means at that year one person's dead, so total --
		//the year(index) with most population alive is the index we want
		int total = 0;
		int max = 0;
		int res = 0;
		for(int i = 0; i < count.length; i ++){
			total += count[i];
			if(total > max){
				max = total;
				res = i;
			}
		}
		
		return res;
	}
	
	public int amazingNumNaive(int[] nums){
		int res = 0;
		int max = 0;
		for(int i = 0; i < nums.length; i ++){ //for each element to be the first element
			int count = 0;
			int index = i;
			for(int j = 0; j < nums.length; j ++){
				if(index > nums.length - 1) index = 0;
				if(nums[index] <= j) count ++;
				index ++;
			}
			if(count > max){
				max = count;
				res = i;
			}
		}
		
		return res;
	}
}
