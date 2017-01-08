package leetcode;

import java.util.HashMap;

public class word_pattern {
	//leetcode 291. Word Pattern II
	
	//leetcode 205 Isomorphic Strings
	public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i ++){
        	if(map.containsKey(s.charAt(i))){
        		if(map.get(s.charAt(i)) != t.charAt(i)) return false;
        	}else{
        		if(map.containsValue(t.charAt(i))) return false;
        		map.put(s.charAt(i), t.charAt(i));
        	}
        }
        return true;
    }
	
	//leetcode 290. Word Pattern
	public boolean wordPattern(String pattern, String str) {
		if(pattern == null || str == null) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length) return false;
        for(int i = 0; i < arr.length; i ++){
        	if(map.containsKey(pattern.charAt(i))){
        		String tmp = map.get(pattern.charAt(i));
        		if(!tmp.equals(arr[i])) return false;
        	}else{
        		if(map.containsValue(arr[i])) return false;
        		map.put(pattern.charAt(i), arr[i]);
        	}
        }
        return true;
    }
}
