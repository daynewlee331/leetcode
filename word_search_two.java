package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_search_two {
	public static void main(String[] args){
		word_search_two sol = new word_search_two();
		char[][] board = {{'a','b'},{'c', 'd'}};
		sol.findWords(board, new String[]{"cdba"});
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		if(board == null || board.length < 1) return new ArrayList<String>();
		Trie trie = new Trie();
		for(String word: words) trie.insert(word);
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board[0].length; j ++){
				boolean[][] visited = new boolean[board.length][board[0].length];
				search(trie, board, words, i, j, visited, "", set);
			}
		}
		return new ArrayList<String>(set);
    }
	
	public void search(Trie trie, char[][] board, String[] words, int row, int col, boolean[][] visited, String cur, Set<String> res){
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
		if(visited[row][col]) return;
		cur += board[row][col];
		visited[row][col] = true;
		if(!trie.startsWith(cur)) return;
		if(trie.search(cur)){
			res.add(cur);
			return;
		}
		search(trie, board, words, row - 1, col, visited, new String(cur), res);
		search(trie, board, words, row + 1, col, visited, new String(cur), res);
		search(trie, board, words, row, col - 1, visited, new String(cur), res);
		search(trie, board, words, row, col + 1, visited, new String(cur), res);
	}
}
