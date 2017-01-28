package leetcode;

public class fibonacci_dp {
	public static void main(String[] args){
		fibonacci_dp sol = new fibonacci_dp();
		int a = sol.fibonacci(10);
		System.out.println(a);
	}
	
	public int fibonacci(int n){
		if(n == 1) return 0;
		if(n == 2) return 1;
		int[] dp = new int[n + 1];
		dp[1] = 0;
		dp[2] = 1;
		for(int i = 3; i <= n; i ++){
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
