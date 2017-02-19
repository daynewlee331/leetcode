package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AllOne {
	HashMap<String, Node> map = null;
	Node head = null;
	
	/** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0);
        map = new HashMap<>();
        head.next = head;
        head.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
        	//get current node of key
        	Node curNode = map.get(key);
        	if(curNode.next.val == curNode.val + 1){
        		curNode.next.set.add(key);
        		map.put(key, curNode.next);
        	}else{
        		//create and insert new node
        		Node newNode = new Node(curNode.val + 1);
        		Node nextNode = curNode.next;
        		curNode.next = newNode;
        		newNode.next = nextNode;
        		nextNode.prev = newNode;
        		newNode.prev = curNode;
        		//update the set and map
        		newNode.set = new HashSet<String>();
        		newNode.set.add(key);
        		map.put(key, newNode);
        	}
        	//remove key from old set
        	curNode.set.remove(key);
        	if(curNode.set.isEmpty())//delete node if necessary
        		removeNode(curNode);
        }else{
        	if(head.next.val == 1){
        		head.next.set.add(key);
        		map.put(key, head.next);
        	}else{
        		//create and insert new node
        		Node newNode = new Node(1);
        		Node next = head.next;
        		head.next = newNode;
        		newNode.next = next;
        		next.prev = newNode;
        		newNode.prev = head;
        		
        		newNode.set = new HashSet<String>();
        		newNode.set.add(key);
        		map.put(key, newNode);
        	}
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)) return;
        Node curNode = map.get(key);
        if(curNode.prev.val == curNode.val - 1){
        	if(curNode.prev.val == 0){
        		map.remove(key);
        	}else{
        		curNode.prev.set.add(key);
            	map.put(key, curNode.prev);
        	}
        }else{
        	Node newNode = new Node(curNode.val - 1);
        	Node prevNode = curNode.prev;
        	prevNode.next = newNode;
        	newNode.next = curNode;
        	curNode.prev = newNode;
        	newNode.prev = prevNode;
        	newNode.set = new HashSet<String>();
        	newNode.set.add(key);
        	map.put(key, newNode);
        }
      //remove key from old set
    	curNode.set.remove(key);
    	if(curNode.set.isEmpty())//delete node if necessary
    		removeNode(curNode);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(head.prev.val != 0) return head.prev.set.iterator().next();
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.next.val != 0) return head.next.set.iterator().next();
        return "";
    }
    
	public void removeNode(Node curNode) {
		if (curNode.val == 0) return;
		Node prevNode = curNode.prev;
		Node nextNode = curNode.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}
	
    class Node{
    	Set<String> set = null;
    	int val;
    	Node prev;
    	Node next;
    	Node(int v){
    		this.val = v;
    	}
    }
}
