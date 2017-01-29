package leetcode;

import java.util.HashMap;

public class longest_substring_unique_character_k {
	public static void main(String[] args){
		longest_substring_unique_character_k sol = new longest_substring_unique_character_k();
		int a = sol.lengthOfLongestSubstringKDistinct("aa", 2);
		System.out.println(a);
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0; int max = 0;
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			while(map.size() > k){
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				if(map.get(leftChar) == 0) map.remove(leftChar);
				left ++;
			}
			max = Math.max(max, i - left + 1);
		}
		return max;
		
    }
}
