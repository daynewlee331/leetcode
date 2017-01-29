package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Task schedule: given a sequence of task like A B C(means 3 different tasks), and a coldtime, 
 * which means you need to wait for that much time to start next [same] task. Now---- 
 * Input: string, n 
 * Output: the best task-finishing sequence. 
 * eg. input: AAABBB, 2 
 * Output: AB_AB_AB ( "_" represents do nothing and wait)	
 * */

public class task_schedule {
	class Task{
		char name;
		int freq;
		Task(char name, int freq){
			this.name = name;
			this.freq = freq;
		}
	}
	
	public static void main(String[] args){
		task_schedule sol = new task_schedule();
		String s = sol.taskSequence("AAABBB", 2);
		System.out.println(s);
	}
	
	public String taskSequence(String tasks, int k){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < tasks.length(); i ++){
			char c = tasks.charAt(i);
			if(map.containsKey(c)){
				int tmp = map.get(c);
				map.put(c, tmp + 1);
			}else{
				map.put(c, 1);
			}
		}
		
		PriorityQueue<Task> pq = new PriorityQueue<Task>(new Comparator<Task>(){
			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;
			}
		});
		
		String res = "";
		ArrayList<Task> buff = new ArrayList<Task>();
		for(char c: map.keySet()){
			pq.add(new Task(c, map.get(c)));
		}
		
		while(!pq.isEmpty()){
			buff.clear();
			for(int i = 0; i <= k && pq.size() > 0; i ++){
				Task t = pq.poll();
				res += t.name;
				buff.add(t);
			}
			
			for(Task t: buff){
				t.freq --;
				if(t.freq > 0) pq.offer(t);
			}
			
			for(int i = 0; i < k + 1 - buff.size(); i ++)res += '_';
		}
		
		return res;
	}
}
