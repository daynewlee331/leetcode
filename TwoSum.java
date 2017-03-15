package leetcode;

import java.util.HashMap;

public class TwoSum {
	private HashMap<Integer, Integer> map = null;
	/** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) map.put(number, 2);
        else map.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int e: map.keySet()){
        		int diff = value - e;
        		if(diff == e) {
        			if(map.get(e) == 2) return true;
        		}
        		else if(map.containsKey(diff)) return true;
        }
        return false;
    }
}
