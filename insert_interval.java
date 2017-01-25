package leetcode;

import java.util.ArrayList;
import java.util.List;

public class insert_interval {
	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	//leetcode 57 insert interval
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		for(Interval inter: intervals){
			if(newInterval == null || inter.end < newInterval.start) res.add(inter);
			else if(inter.start > newInterval.end) {
				//if(newInterval != null){
					res.add(newInterval);
					res.add(inter);
					newInterval = null;
				//}
			}else{
				newInterval.end = Math.max(newInterval.end, inter.end);
				newInterval.start = Math.min(newInterval.start, inter.start);
			}
		}
		if(newInterval != null) res.add(newInterval);
		return res;
    }
}
