package leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class max_time {
	public static void main(String[] args){
		max_time sol = new max_time();
		String s = sol.getTime(2, 4, 0, 0);
		System.out.println(s);
	}
	
	class Time{
		int hour;
		int min;
		String time;
		Time(int h, int m, String t){
			this.hour = h;
			this.min = m;
			this.time = t;
		}
	}
	public String getTime(int a, int b, int c, int d){
		if(a < 0 || b < 0 || c < 0 || d < 0) return "NOT POSSIBLE";
		if(a > 9 || b > 9 || c > 9 || d > 9) return "NOT POSSIBLE";
		Set<Integer> visited = new HashSet<Integer>();
		PriorityQueue<Time> pq = new PriorityQueue<Time>(new Comparator<Time>(){
			@Override
			public int compare(Time o1, Time o2) {
				// TODO Auto-generated method stub
				if(o2.hour > o1.hour) return 1;
				else if(o2.hour == o1.hour){
					if(o2.min > o1.min) return 1;
					else if(o2.min == o1.min) return 0;
					else return -1;
				}else return -1;
			}
		});
		int[] nums = {a, b, c, d};
		for(int i = 0; i < nums.length; i ++){
			visited.add(i);
			for(int j = 0; j < nums.length; j ++){
				if(visited.contains(j)) continue;
				visited.add(j);
				String hrSt = nums[i] + "" + nums[j];
				for(int p = 0; p < nums.length; p ++){
					if(visited.contains(p)) continue;
					visited.add(p);
					for(int q = 0; q < nums.length; q ++){
						if(visited.contains(q)) continue;
						visited.add(q);
						String minSt = nums[p] + "" + nums[q];
						int hr = Integer.parseInt(hrSt);
						int min = Integer.parseInt(minSt);
						if(hr >= 0 && hr <= 23 && min >= 0 && min <= 59) 
							pq.add(new Time(hr, min, hrSt + ":" + minSt));
						visited.remove(q);
					}
					visited.remove(p);
				}
				visited.remove(j);
			}
			visited.remove(i);
		}
		
		return pq.isEmpty()? "NOT POSSIBLE" : pq.poll().time;
	}
}
