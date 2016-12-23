package leetcode;

import java.util.HashMap;

public class min_window_substring {
	public static void main(String[] args){
		min_window_substring mw = new min_window_substring();
		mw.minWindow("a", "b");
	}
	
	public String minWindow(String s, String t) {
        String res = "";
        if(s == null || t == null || s.length() < 1 || t.length() < 1) return res;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i ++){
        	char ch = t.charAt(i);
        	if(map.containsKey(ch)){
        		int num = map.get(ch);
        		map.put(ch, num + 1);
        	}else{
        		map.put(ch, 1);
        	}
        }
        
        int count = 0;
        int pre = 0;
        int min = s.length()+1;
        
        for(int i = 0; i < s.length(); i ++){
        	if(map.containsKey(s.charAt(i))){
             map.put(s.charAt(i),map.get(s.charAt(i))-1);
             if(map.get(s.charAt(i)) >= 0) count++;}
        	
        	while(count == t.length()){
        		if(map.containsKey(s.charAt(pre))) {
        			int num = map.get(s.charAt(pre));
            		map.put(s.charAt(pre), num + 1);
        		}
        		if(map.containsKey(s.charAt(pre)) && map.get(s.charAt(pre)) > 0){
        			if(min > i - pre + 1){
        				res = s.substring(pre, i + 1);
        				min = i - pre + 1;
        			}
        			count --;
        		}
        		
        		pre ++;
        	}
        }
        
        return res;
    }
}
