package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph_valid_tree {
	public static void main(String[] args){
		graph_valid_tree gvt = new graph_valid_tree();
		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		gvt.findOrder(10, prerequisites);
	}
	
	//leetcode 210 Course Schedule II
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses == 0) return null;
		int[] inDegree = new int[numCourses];
		int[] order = new int[numCourses];
		int index = 0;
		for(int[] edge: prerequisites){
			inDegree[edge[0]] ++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int j = 0; j < inDegree.length; j ++){
			if(inDegree[j] == 0) {
				order[index ++] = j;
				queue.offer(j);
			}
		}
		while(!queue.isEmpty()){
			int prerequisite = queue.poll();
			for(int i = 0; i < prerequisites.length; i ++){
				if(prerequisites[i][1] == prerequisite){
					int course = prerequisites[i][0];
					inDegree[course] --;
					if(inDegree[course] == 0){
						order[index ++] = course;
						queue.offer(course);
					}
				}
			}
		}
		return index == numCourses? order: new int[0];
    }
	
	//leetcode 261: graph valid tree
	//According to the definition of tree on Wikipedia: 
	//“a tree is an undirected graph in which any two vertices are connected by exactly one path. 
	//In other words, any connected graph without simple cycles is a tree.”
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
