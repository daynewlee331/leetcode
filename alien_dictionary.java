package leetcode;

import java.util.Arrays;

//leetcode 269
/*
 * A topological ordering is possible if and only if the graph has no directed cycles, 
 * that is, if it is a directed acyclic graph (DAG).
 * Build a graph and perform a DFS.
 * visited[i] = -1. Not even exist.
 * visited[i] = 0. Exist. Non-visited.
 * visited[i] = 1. Visiting.
 * visited[i] = 2. Visited.
 */
public class alien_dictionary {
	int N = 26;
	public String alienOrder(String[] words) {
		if(words == null || words.length < 1) return null;
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        createGraph(visited, adj, words);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++){
        	if(visited[i] == 0){//unvisited
        		if(!bfs(visited, adj, sb, i)) return "";
        	}
        }
        return sb.reverse().toString();
    }
	
	public boolean bfs(int[] visited, boolean[][] graph, StringBuilder sb, int i){
		visited[i] = 1;
		for(int j = 0; j < N; j ++){
			if(graph[i][j]){
				if(visited[j] == 1) return false;
				if(visited[j] == 0){
					if(!bfs(visited, graph, sb, j)) return false;
				}
			}
		}
		visited[i] = 2;
		sb.append((char)(i + 'a'));
		return true;
 	}
	
	public void createGraph(int[] visited, boolean[][] graph, String[] words){
		Arrays.fill(visited, -1);
		for(int i = 0; i < words.length; i ++){
			char[] charArr = words[i].toCharArray();
			for(char ch: charArr) visited[ch - 'a'] = 0;
			if(i > 0){
				String w1 = words[i - 1]; String w2 = words[i];//get words that are adjicent to each other
				if (!w1.equals(w2) && w1.startsWith(w2)) {
			        Arrays.fill(visited, 2);
			        return;
			    }
				int len = Math.min(w1.length(), w2.length());
				for(int j = 0; j < len;  j++){
					char c1 = w1.charAt(j); char c2 = w2.charAt(j);
					if(c1 != c2){
						graph[c1 - 'a'][c2 - 'a'] = true;
						break;
					}
				}
			}
		}
	}
}
