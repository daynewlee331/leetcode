package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class sliding_window_maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 1 || k < 1) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i ++){
        		if(deque.size() > 0 && deque.peekFirst() == i - k) deque.removeFirst();
        		while(deque.size() > 0 && nums[i] > nums[deque.getLast()])
        			deque.removeLast();
        		deque.offer(i);
        		if(i < k - 1) continue;
        		res[i - k + 1] = nums[deque.peek()];
        		
        }
        return res;
    }
}
