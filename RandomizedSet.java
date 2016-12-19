package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {
	public static void main(String[] args){
		RandomizedSet rs = new RandomizedSet();
		rs.insert(3);
		rs.insert(3);
		System.out.println(rs.getRandom());
		System.out.println(rs.getRandom());
		rs.insert(1);
		rs.remove(3);
		System.out.println(rs.getRandom());
		System.out.println(rs.getRandom());
		rs.insert(0);
		rs.remove(0);
	}
	
	/** Initialize your data structure here. */
	int count = 0;
	Random r = null;
	HashMap<Integer, Integer> valToIndex = null;
	HashMap<Integer, Integer> indexToVal = null;
	
    public RandomizedSet() {
        this.count = 0;
        this.valToIndex = new HashMap<Integer, Integer>();
        this.indexToVal = new HashMap<Integer, Integer>();
        this.r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(this.valToIndex.containsKey(val)) return false;
		this.valToIndex.put(val, this.count);
		this.indexToVal.put(this.count, val);
		this.count++;
		return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!this.valToIndex.containsKey(val) || this.count < 1) return false;
        int index = this.valToIndex.get(val);
        
        this.valToIndex.remove(val);
        this.indexToVal.remove(index);
        
        int tmp = this.count - 1;
        if(tmp > 0 && tmp != index){
        	int sub = this.indexToVal.get(tmp);
            this.valToIndex.put(sub, index);
            this.indexToVal.remove(tmp);
            this.indexToVal.put(index, sub);
        }
        this.count --;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int i = this.r.nextInt(this.count);
    	return this.indexToVal.get(i);
    }
}
