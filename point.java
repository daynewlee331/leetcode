package leetcode;

public class point {
	double x;
	double y;
	double distance;
	public point(double x, double y){
		this.x = x;
		this.y = y;
		this.distance = Math.sqrt(x * x + y * y);
	}
}
