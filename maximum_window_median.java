package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class maximum_window_median {
	public static void main(String[] args){
		maximum_window_median sol = new maximum_window_median();
		sol.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
	}
	
	public double[] medianSlidingWindow(int[] nums, int k) {
		double[] res = new double[nums.length - k + 1];
		int j = 0;
		if(nums == null || nums.length < 1 || k < 1) return new double[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i <= nums.length; i ++){
        	if(minHeap.size() + maxHeap.size() < k){
        		add(maxHeap, minHeap, nums[i]);
        	}
        	else if(minHeap.size() + maxHeap.size() == k){
        		res[j ++] = getMedian(maxHeap, minHeap);
        		remove(maxHeap, minHeap, nums[i - k]);
        		if(i == nums.length) break;
        		add(maxHeap, minHeap, nums[i]);
        	}
        }
        return res;
    }
	
	public void remove(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int target){
		if(minHeap.contains(target)) minHeap.remove(target);
		else if(maxHeap.contains(target)) maxHeap.remove(target);
		if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
	}
	
	public void add(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int target){
		maxHeap.offer(target);
		minHeap.offer(maxHeap.poll());
		if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
	}
	
	public double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
		if(maxHeap.size() == minHeap.size()) return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
		return maxHeap.peek();
	}
}
