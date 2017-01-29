package leetcode;

public class unqie_path {
	public static void main(String[] args){
		unqie_path sol = new unqie_path();
		sol.uniquePathsWithObstacles(new int[][]{{0}});
	}
	
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0) return 0;
		if(m == 1 || n == 1) return 1;
		int[][] dp = new int[m][n];
		for(int i = 0; i < n; i ++){
			dp[0][i] = 1;
		}
		
		for(int i = 0; i < m; i ++){
			dp[i][0] = 1;
		}
		
		for(int i = 1; i < m; i ++){
			for(int j = 1; j < n; j ++){
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
    }
	
	public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        
        for(int i = 0; i < m; i ++){
        	for(int j = 0; j < n; j ++){
        		if(a[i][j] == 1) a[i][j] = 0;
        		else{
        			if(i == 0 && j == 0) a[i][j] = 1;
            		else if(i == 0 && j > 0) a[i][j] = a[i][j - 1];
            		else if(j == 0 && i > 0) a[i][j] = a[i - 1][j];
            		else a[i][j] = a[i - 1][j] + a[i][j - 1];
        		}
        	}
        }
        
        return a[m - 1][n - 1];
    }
}
