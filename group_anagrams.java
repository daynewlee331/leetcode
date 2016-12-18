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
	
	public boolean isAnagrams(String s1, String s2){
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		if(s1.length() != s2.length()) return false;
		for(int i = 0; i < s1.length(); i ++){
			if(hm.containsKey(s1.charAt(i))){
				int num = hm.get(s1.charAt(i));
				hm.put(s1.charAt(i), num + 1);
			}else{
				hm.put(s1.charAt(i), 1);
			}
		}
		for(int j = 0; j < s2.length(); j ++){
			if(hm.containsKey(s2.charAt(j))){
				int num = hm.get(s2.charAt(j));
				if(num == 0) return false;
				hm.put(s2.charAt(j), num - 1);
			}else{
				return false;
			}
		}
		
		return true;
	}
}
