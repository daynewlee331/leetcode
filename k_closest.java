package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_closest {
	public static void main(String[] args){
		k_closest obj = new k_closest();
		point[] points = new point[3];
		points[0] = new point(1,1);
		points[1] = new point(2,2);
		points[2] = new point(3,3);
		obj.closestK(points, 3);
	}
	
	public point[] closestK(point[] points, int k) {
		if (points == null) return null;
		if (k < 1) return new point[0];
		PriorityQueue<point> pq = new PriorityQueue<point>(k, new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				if (o2.distance < o1.distance) return -1;
				else if (o2.distance > o1.distance) return 1;
				else return 0;
			}
		});
		for(point p: points){
			if(pq.size() < k) pq.offer(p);
			else if(p.distance < pq.peek().distance){
				pq.poll();
				pq.offer(p);
			}
		}
		
		return pq.toArray(new point[k]);
	}

}
