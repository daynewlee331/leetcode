package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class word_pattern {
	public static void main(String[] args){
		word_pattern wp = new word_pattern();
		wp.wordPatternMatch("abba", "redbluebluered");
	}
	
	//leetcode 291. Word Pattern II
	public boolean wordPatternMatch(String pattern, String str){
		HashMap<String, String> map = new HashMap<String, String>();
		HashSet<String> set = new HashSet<String>();
		return wordPatternMatchHelper(pattern, str, map, set);
	}
	
	public boolean wordPatternMatchHelper(String pattern, String str, HashMap<String, String> map, HashSet<String> set){
		if(pattern.isEmpty()) return str.isEmpty();
		if(map.containsKey(pattern.substring(0,1))){
			String word = map.get(pattern.substring(0, 1));
			if(str.length() < word.length() || !str.substring(0, word.length()).equals(word)) return false;
			if(wordPatternMatchHelper(pattern.substring(1), str.substring(word.length()), map, set)) return true;
		}else{
			for(int i = 1; i <= str.length(); i ++){
				String sub = str.substring(0, i);
				if(set.contains(sub)) continue;
				String key = pattern.substring(0, 1);
				map.put(key, sub);
				set.add(sub);
				if(wordPatternMatchHelper(pattern.substring(1), str.substring(i), map, set)) return true;
				set.remove(sub);
				map.remove(key);
			}
		}
		return false;
	}
	
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
