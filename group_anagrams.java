package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class group_anagrams {
	public static void main(String[] args){
		group_anagrams ga = new group_anagrams();
		String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = ga.groupAnagrams(test);
		System.out.println();
	}
	//leeetcode 49. Group Anagrams
	//
	// Given an array of strings, group anagrams together.
	// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	// Return:[ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
	// 
	//
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		if(strs == null || strs.length < 1) return res;
		Arrays.sort(strs);
		for(String st : strs){
			char[] ch = st.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(st);
		}
		return new ArrayList<List<String>>(map.values());
    }
	
	public List<List<String>> my_groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		if(strs == null || strs.length < 1) return res;
		for(String st : strs){
			boolean flag = false;
			for(String mapString: map.keySet()){
				if(isAnagrams(st, mapString)){
					map.get(mapString).add(st);
					flag = true;
					break;
				}
			}
			if(!flag){
				List<String> buff = new ArrayList<String>();
				buff.add(st);
				map.put(st, buff);
			}
		}
		
		for (String s : map.keySet()) res.add(map.get(s));
		return res;
    }
	
	//leetcode 242. Valid Anagram
	public boolean isAnagrams(String s, String t){
		char[] arr = new char[26];
		if(s.length() != t.length()) return false;
		for(int i = 0; i < s.length(); i ++){
			arr[s.charAt(i) - 'a'] ++;
			arr[t.charAt(i) - 'a'] --;
		}
		for(int i = 0; i < arr.length; i ++){
			if(arr[i] != 0) return false;
		}
		return true;
	}
}
