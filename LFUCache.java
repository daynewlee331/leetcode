package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	private HashMap<Integer, Integer> vals = null;
	private HashMap<Integer, Node> counts = null;
	private Node head = null;
	private int cap = 0;
	
	public LFUCache(int capacity) {
        head = new Node(-1);
        head.next = head;
        head.prev = head;
        vals = new HashMap<Integer, Integer>();
        counts = new HashMap<Integer, Node>();
        this.cap = capacity;
    }
    
    public int get(int key) {
    	if(!vals.containsKey(key)) return -1;
    	int res = vals.get(key);
    	Node cur = this.counts.get(key);
    	if(cur.next.count != cur.count + 1){
    		Node oneMore = new Node(cur.count + 1);
    		insert(cur, oneMore);
    	}
    	Node next = cur.next;
    	next.list.add(key);
    	this.counts.put(key, next);
    	//delete key from previous node
    	cur.list.remove(key);
    	if(cur.list.isEmpty()){
    		remove(cur);
    	}
    	return res;
    }
    
    public void put(int key, int value) {
    	if (cap == 0) return;
    	if(vals.containsKey(key)){
    		this.vals.put(key, value);
    		get(key);
    		return;
    	}
        Node next = head.next;
        if(next.count != 1){
        	Node one = new Node(1);
        	insert(head, one);// insert one after head
        }
        if(vals.size() + 1 > this.cap){//delete element
        	int toDel = next.list.iterator().next();
        	vals.remove(toDel);
        	next.list.remove(toDel);
        	if(next.count != 1 && next.list.isEmpty()){
        		remove(next);
        	}
        	counts.remove(toDel);
        }
        //add new element
        this.vals.put(key, value);
        Node one = head.next;
        this.counts.put(key, one);
        one.list.add(key);
    }
   
    public void remove(Node target){
    	Node prev = target.prev;
		Node after = target.next;
		prev.next = after;
		after.prev = prev;
    }
    
    public void insert(Node previous, Node newNode){
    	newNode.list = new LinkedHashSet<>();
    	Node next = previous.next;
    	previous.next = newNode;
    	newNode.next = next;
    	next.prev = newNode;
    	newNode.prev = previous;
    }
    
    class Node{
    	int count = 0;
    	LinkedHashSet<Integer> list = null;
    	Node prev = null;
    	Node next = null;
    	public Node(int x){
    		this.count = x;
    	}
    }
}
