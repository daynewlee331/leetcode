package leetcode;

public class shortest_word_distance {
	public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length < 1 || word1 == null || word2 == null) return -1;
        int res = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < words.length; i ++){
        	if(words[i].equals(word1)) index1 = i;
        	if(words[i].equals(word2)) index2 = i;
        	if(index1 >= 0 && index2 >= 0){
        		res = Math.min(res, Math.abs(index1 - index2));
        	}
        }
        return res;
    }
}
