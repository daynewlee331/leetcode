package leetcode;

public class Rectangle_Area {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        int overlap = 0;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int upper = Math.min(D, H);
        int lower = Math.max(B, F);
        if(right > left && upper > lower) overlap = (right - left) * (upper - lower);
        return total - overlap;
    }
}
