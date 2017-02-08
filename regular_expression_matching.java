package leetcode;
//leetcode 10 Regular Expression Matching
/*
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 */
public class regular_expression_matching {
	
	/*
	 * 1: If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	 * 2: If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
	 * 3: If p.charAt(j) == '*': 
	 * 		a: if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  
	 * 				in this case, a* only counts as empty, because * can matches zero preceding elements	
	 * 		b: if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
	 * 				dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
	 *              or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
	 *              or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	 * 
	 * */
		public boolean isMatch(String s, String p) {
			if(s == null || p == null) return false;
			boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
			dp[0][0] = true;
			for(int i = 0; i < p.length() ; i ++){
				if(p.charAt(i) == '*' && dp[0][i - 1]) dp[0][i + 1] = true;
			}
			
			for(int i = 0; i < s.length(); i ++){
				for(int j = 0; j < p.length(); j ++){
					if(s.charAt(i) == p.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
					if(p.charAt(j) == '.') dp[i + 1][j + 1] = dp[i][j];
					if(p.charAt(j) == '*'){
						if(j > 0 && p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
							dp[i + 1][j + 1] = dp[i + 1][j - 1];
						else{
							dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1] || dp[i + 1][j];
						}
					}
				}
			}
			return dp[s.length()][p.length()];
		}
	
	/*
	 * 这个题目比较常见，但是难度还是比较大的。我们先来看看brute force怎么解决。
	 * 基本思路就是先看字符串s和p的从i和j开始的子串是否匹配，用递归的方法直到串的最后，最后回溯回来得到结果。假设现在走到s的i位置，p的j位置，情况分为下列两种： 
	 * (1)p[j+1]不是'*'。情况比较简单，只要判断当前s的i和p的j上的字符是否一样（如果有p在j上的字符是'.',也是相同），如果不同，返回false，否则，递归下一层i+1，j+1; 
	 * (2)p[j+1]是'*'。那么此时看从s[i]开始的子串，假设s[i],s[i+1],...s[i+k]都等于p[j]那么意味着这些都有可能是合适的匹配，
	 * 那么递归对于剩下的(i,j+2),(i+1,j+2),...,(i+k,j+2) 都要尝试（j+2是因为跳过当前和下一个'*'字符）。 =
	 */
	public boolean isMatchRecur(String s, String p) {
		return isMatchHelper(s, p, 0, 0);
    }
	
	public boolean isMatchHelper(String s, String p, int i, int j){
		if(i == s.length()) return j == p.length();
		//j should be faster than i
		if(j == p.length() - 1 || p.charAt(j + 1) != '*'){
			if(i == s.length() || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '.')) return false;
		}
		//if p.charAt(j + 1) == '*';
		while(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')){
			if(isMatchHelper(s, p, i, j + 2)) return true;
			i ++;
		}
		// '*' zero matches, e.g: isMatch("aab", "c*a*b") → true
		return isMatchHelper(s, p, i, j + 2);
	}
}
