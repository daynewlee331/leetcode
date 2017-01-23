package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class sliding_window_maximum {
	public static void main(String[] args){
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(1);
		q.offer(2);
		q.offer(5);
		q.offer(4);
		q.offer(3);
		System.out.println(q.peekFirst());
		System.out.println(q.peekLast());
		System.out.println(q.peek());
		System.out.println(q.poll());
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 1 || k < 1) return new int[0];
		int n = nums.length;
		Deque<Integer> indexQ = new ArrayDeque<>();
		int[] res = new int[n - k + 1];
		int j = 0;
		for(int i = 0; i < nums.length; i ++){
			while(!indexQ.isEmpty() && indexQ.peekFirst() < (i - k + 1)) indexQ.pollFirst();
			while(!indexQ.isEmpty() && nums[indexQ.peekLast()] < nums[i]) indexQ.pollLast();
			indexQ.offer(i);
			if(i >= k - 1) {
					res[j] = nums[indexQ.peekFirst()];
					j ++;
			}
		}
		return res;
    }
}
