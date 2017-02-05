package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
	public String alienOrderBFS(String[] words){
		if(words == null || words.length < 1) return "";
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> inDegree = new HashMap<Character, Integer>();
		//initialize inDegree map
		for(String word: words){
			for(int i = 0; i < word.length(); i ++){
				char c = word.charAt(i);
				inDegree.put(c, 0);
			}
		}
		
		//create adjacency list
		for(int i = 0; i < words.length - 1; i ++){
			String cur = words[i];
			String next = words[i + 1];
			int len = Math.min(cur.length(), next.length());
			for(int j = 0; j < len; j ++){
				char c1 = cur.charAt(j); //source node
				char c2 = next.charAt(j);//dest node
				if(c1 != c2){
					Set<Character> set = new HashSet<Character>();
					if(map.containsKey(c1)) set = map.get(c1);
					if(!set.contains(c2)){
						set.add(c2);
						map.put(c1, set);
						inDegree.put(c2, inDegree.get(c2) + 1);
					}
					break;
				}else{
					if(j + 1 <= cur.length() - 1 && j + 1 > next.length() - 1) return "";
				}
			}
		}
		
		//BFS
		Queue<Character> queue = new LinkedList<Character>();
		StringBuilder builder = new StringBuilder();
		for(Character c : inDegree.keySet()){
			if(inDegree.get(c) == 0) queue.add(c);
		}
		
		while(!queue.isEmpty()){
			char node = queue.poll();
			builder.append(node);
			if(map.containsKey(node)){
				for(Character neighbor: map.get(node)){
					int num = inDegree.get(neighbor);
					inDegree.put(neighbor, num - 1);
					if(num - 1 == 0){
						queue.offer(neighbor);
					}
				}
			}
		}
		
		return builder.length() == inDegree.size()? builder.toString(): "";
	}
	
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
