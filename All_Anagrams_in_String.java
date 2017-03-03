package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class All_Anagrams_in_String {
	public static void main(String[] args){
		All_Anagrams_in_String sol = new All_Anagrams_in_String();
		sol.findAnagrams("ccbaebabacd", "abc");
		System.out.println();
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
		if(s == null || p == null || s.length() < 1 || s.length() < p.length()) return res;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for(int i = 0; i < p.length(); i ++){
			char c = p.charAt(i);
			if(!map.containsKey(c)) map.put(c, 1);
			else map.put(c, map.get(c) + 1);
			count ++;
		}
		int left = 0, right = 0;
		while(right < s.length()){
			char ch = s.charAt(right);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) - 1);
				if(map.get(ch) >= 0) count --;
			}
			while(count == 0){
				if(right - left + 1 == p.length()) res.add(left);
				char leftCh = s.charAt(left);
				if(map.containsKey(leftCh)){
					map.put(leftCh, map.get(leftCh) + 1);
					if(map.get(leftCh) > 0) count ++;
				}
				left ++;
			}
			right ++;
		}
		return res;
    }
}
