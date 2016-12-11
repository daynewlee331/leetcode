package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class clone_graph {
	
	public static void main(String[] args){
		clone_graph c = new clone_graph();
		/*
		UndirectedGraphNode one = new UndirectedGraphNode(1);
		UndirectedGraphNode two = new UndirectedGraphNode(2);
		UndirectedGraphNode three = new UndirectedGraphNode(3);
		one.neighbors = new ArrayList<UndirectedGraphNode>();
		one.neighbors.add(two);
		one.neighbors.add(three);
		two.neighbors = new ArrayList<UndirectedGraphNode>();
		two.neighbors.add(three);*/
		
		//UndirectedGraphNode res = c.cloneGraph(one);
		System.out.println();
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();//hashMap to store known nodes
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		map.put(node.label, res);
		cloneGraphHelper(res, node,map);
		return res;
	}
	
	public void cloneGraphHelper(UndirectedGraphNode copy, UndirectedGraphNode origin
			, HashMap<Integer, UndirectedGraphNode> map) {
		copy.neighbors = new ArrayList<UndirectedGraphNode>();
		for(int i = 0; i < origin.neighbors.size(); i ++ ){
			UndirectedGraphNode neighbor = origin.neighbors.get(i);
			if(map.containsKey(neighbor.label)){
				copy.neighbors.add(map.get(neighbor.label));
			}else{
				UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor.label, tmp);
				copy.neighbors.add(tmp);
				cloneGraphHelper(tmp, neighbor, map);
			}
		}
	}
}
