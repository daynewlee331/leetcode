package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class group_shifted_strings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s: strings){
			String key = generateKey(s);
			if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		for(String k: map.keySet()){
			res.add(map.get(k));
		}
		return res;
    }
	
	public String generateKey(String s){
		if(s.charAt(0) == 'a') return s;
		StringBuilder builder = new StringBuilder();
		int shift = s.charAt(0) - 'a';
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c - 'a' - shift >= 0) builder.append((char)(c - shift));
			else builder.append((char)(c - shift + 26));
		}
		return builder.toString();
	}
}
