package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class clone_graph {
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
