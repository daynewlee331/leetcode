package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	//leetcode 295
	/** initialize your data structure here. */
	PriorityQueue<Integer> min = null;
	PriorityQueue<Integer> max = null;
	
    public MedianFinder() {
    	this.min = new PriorityQueue<Integer>();
    	this.max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        return max.peek();
    }
}
