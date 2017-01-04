package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class remove_invalid_parentheses {
	public static void main(String[] args){
		remove_invalid_parentheses rp = new remove_invalid_parentheses();
		rp.removeInvalidParentheses("()())()");
	}
	
	//leetcode 301. Remove Invalid Parentheses
	//Remove the minimum number of invalid parentheses in order to make the input string valid.
	/*
	 * The idea is straightforward:
	 * with the input string s, we generate all possible states by removing one ( or ), 
	 * check if they are valid, if found valid ones on the current level,
	 * put them to the final result list and we are done.
	 * Otherwise, add them to a queue and carry on to the next level.
	 * The good thing of using BFS is that we can guarantee the number of parentheses to be removed is minimal, 
	 * also no recursion call is needed in BFS.
	 * 
	 */
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		if(s == null) return res;
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(s);
		visited.add(s);
		boolean found = false;
		while(!queue.isEmpty()){
			String cur = queue.poll();
			if(isValid(cur)){
				res.add(cur);
				found = true;
			}
			
			if(found) continue;
			
			for(int i = 0; i < cur.length(); i ++){
				if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
				String t = cur.substring(0, i) + cur.substring(i + 1);
				if(!visited.contains(t)){
					queue.add(t);
					visited.add(t);
				}
			}
		}
		
		return res;
    }
	
	public boolean isValid(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c == '(') count ++;
			if(c == ')') count --;
			if(count < 0) return false;
		}
		return count == 0;
	}
}
