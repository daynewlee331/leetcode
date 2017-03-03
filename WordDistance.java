package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
	private HashMap<String, List<Integer>> map = null;
	public WordDistance(String[] words) {
        this.map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i ++){
        	if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<Integer>());
        	map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        if(word1 == null || word2 == null || !map.containsKey(word1) || !map.containsKey(word2)) return 0;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()){
        	int index1 = list1.get(i), index2 = list2.get(j);
        	if(index1 < index2){
        		res = Math.min(index2 - index1, res);
        		i ++;
        	}else{
        		res = Math.min(index1 - index2, res);
        		j ++;
        	}
        }
        return res;
    }
}
