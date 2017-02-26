package leetcode;

public class shortest_word_distance_3 {
	
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        if(word1.equals(word2)){
        	for(int i = 0; i < words.length; i ++){
        		if(words[i].equals(word1)){
        			if(index1 == -1) index1 = i;
        			else{
        				res = Math.min(res, i - index1);
        				index1 = i;
        			}
        		}
        	}
        }else{
        	for(int i = 0; i < words.length; i ++){
            	if(words[i].equals(word1)) index1 = i;
            	if(words[i].equals(word2)) index2 = i;
            	if(index1 >= 0 && index2 >= 0){
            		res = Math.min(res, Math.abs(index1 - index2));
            	}
            }
        }
        return res;
    }
}
