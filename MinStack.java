package leetcode;

import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */
	Stack<Integer> stack = null;
	int min = Integer.MAX_VALUE;
    public MinStack() {
    	this.stack = new Stack<Integer>();
    	this.min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){
        	this.stack.push(min);
        	min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
    	if(this.stack.isEmpty()) return;
        int value = this.stack.pop();
        if(value == min){
        	min = this.stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
