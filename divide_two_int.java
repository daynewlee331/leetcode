package leetcode;

public class divide_two_int {
	public static void main(String[] args){
		divide_two_int obj = new divide_two_int();
		obj.divide_cheat(-2147483648, -1);
	}
	
	public int divide(int dividend, int divisor) {
        
    }
	
	public int divide_cheat(int dividend, int divisor) {
		if(divisor == 1) return dividend;
        if(divisor == 0) return -1;
        
		int sign = 1;
		if(dividend > 0 && divisor < 0) sign = -1;
		if(dividend < 0 && divisor > 0) sign = -1;
		
		long a = Math.abs((long)dividend); 
		long b = Math.abs((long)divisor);
        if(a < b) return 0;
        long left = 1; long right = a;
        long res = -1;
        while(left <= right){
        	long mid = (right + left) / 2;
        	if(mid * b == a)  {res = mid;break;}
        	else if(mid * b < a && (mid + 1) * b > a) {res = mid;break;}
        	else if(mid * b < a) left = mid + 1;
        	else right = mid - 1;
        }
        res = res * sign;
        if(res > 0 && (int)res < 0) return Integer.MAX_VALUE;
        else return (int)res;
    }
}
