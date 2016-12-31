package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph_valid_tree {
	public boolean validTree(int n, int[][] edges) {
		List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < n; i ++){
			list.add(new HashSet<Integer>());
		}
		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
        
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while(!queue.isEmpty()){
			int node = queue.poll();
			if(visited[node]) return false;
			visited[node] = true;
			for(int neighbor: list.get(node)){
				queue.offer(neighbor);
				list.get(neighbor).remove(node);
			}
		}
		//fully connected
		for(boolean res: visited){
			if(!res) return false;
		}
		return true;
        
    }
}
