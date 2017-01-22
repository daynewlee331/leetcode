package leetcode;

public class valid_perfect_square {
	public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        if(num < 1) return true;
        long i = 1; long j = num;
        while(i <= j){
        	long mid = (j - i) / 2 + i;
        	if(mid * mid == num) return true;
        	else if(mid * mid < num) i = mid + 1;
        	else j = mid - 1;
        }
        return false;
    }
}
