package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AllOne {
	public static void main(String[] args){
		AllOne a = new AllOne();
		a.inc("alpha");
		a.inc("alpha");
		a.dec("alpha");
		a.dec("alpha");
		a.inc("alpha");
		a.dec("alpha");
		a.inc("beta");
		a.inc("beta");
		a.inc("gamma");
		a.inc("gamma");
		a.inc("sigma");
		a.inc("sigma");
		a.dec("beta");
		a.dec("beta");
		a.dec("sigma");
		a.dec("sigma");
		a.dec("gamma");
		a.dec("gamma");
		System.out.println(a.getMinKey());
		System.out.println(a.getMaxKey());
	}
	class doublyLinkedListNode{
		int value;
		LinkedList<String> elements = null;
		doublyLinkedListNode prev;
		doublyLinkedListNode next;
		doublyLinkedListNode(int k){
			this.value = k;
			this.elements = new LinkedList<String>();
		}
	}
	
	HashMap<String, doublyLinkedListNode> map = null;
	doublyLinkedListNode fakeHead = null;
	
	/** Initialize your data structure here. */
    public AllOne() {
    	this.map = new HashMap<String, doublyLinkedListNode>();
    	this.fakeHead = new doublyLinkedListNode(0);
    	this.fakeHead.elements = null;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	if(this.fakeHead.next == null) {//data structure is empty
    		doublyLinkedListNode cur = new doublyLinkedListNode(1);
    		cur.elements.add(key);
    		this.map.put(key, cur);
    		this.fakeHead.next = cur;
    		cur.next = this.fakeHead;
    		this.fakeHead.prev = cur;
    		cur.prev = this.fakeHead;
    	}else if(this.map.containsKey(key)){
    		doublyLinkedListNode cur = this.map.get(key);
    		if(cur.next.value == cur.value + 1){
    			this.map.put(key, cur.next);
    			cur.next.elements.add(key);
    			cur.elements.remove(key);
    		}else{//build a new node
    			doublyLinkedListNode newNode = new doublyLinkedListNode(cur.value + 1);
    			newNode.elements.add(key);
    			cur.elements.remove(key);
    			this.map.put(key, newNode);
    			doublyLinkedListNode next = cur.next;
    			cur.next = newNode;
    			newNode.prev = cur;
    			newNode.next = next;
    			next.prev = newNode;
    		}
    		checkEmpty(cur);
    	}else if(!this.map.containsKey(key)){
    		if(this.fakeHead.next.value == 1){//node of value 1 exists
    			doublyLinkedListNode cur = this.fakeHead.next;
    			this.map.put(key, cur);
    			cur.elements.add(key);
    		}else{//node of value 1 doesn't exist, insert node of value 1
    			doublyLinkedListNode cur = new doublyLinkedListNode(1);
    			doublyLinkedListNode tmp = this.fakeHead.next;
    			cur.next = tmp;
    			cur.prev = this.fakeHead;
    			tmp.prev = cur;
    			this.fakeHead.next = cur;
    			this.map.put(key, cur);
    			cur.elements.add(key);
    		}
    	}
    	
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(this.fakeHead.next == null || !this.map.containsKey(key)) return; //no such key in the data structure
        doublyLinkedListNode cur = this.map.get(key);
        if(cur.value - 1 == 0){
        	cur.elements.remove(key);
        	checkEmpty(cur);
        	this.map.remove(key);
        }else{//the node is in the middle
        	if(cur.prev.value == cur.value - 1){
        		this.map.put(key, cur.prev);
            	cur.elements.remove(key);
            	cur.prev.elements.add(key);
            	checkEmpty(cur);
        	}else{//build a new node
        		doublyLinkedListNode newNode = new doublyLinkedListNode(cur.value - 1);
            	this.map.put(key, newNode);
            	cur.elements.remove(key);
            	newNode.elements.add(key);
            	doublyLinkedListNode prev = cur.prev;
            	prev.next = newNode;
            	newNode.next = cur;
            	cur.prev = newNode;
            	newNode.prev = prev;
            	checkEmpty(cur);
        	}
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(this.fakeHead.next == null) return "";
        return this.fakeHead.prev.elements.get(0);
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	if(this.fakeHead.next == null) return "";
    	return this.fakeHead.next.elements.get(0);
    }
    
    public boolean checkEmpty(doublyLinkedListNode node){
    	if(node.elements.size() > 0) return false;
    	doublyLinkedListNode prev = node.prev;
    	doublyLinkedListNode next = node.next;
    	prev.next = next;
    	next.prev = prev;
    	if(next == prev && next == this.fakeHead){//set to empty
    		this.fakeHead.next = null;
    		this.fakeHead.prev = null;
    	}
    	return true;
    }
	
}
