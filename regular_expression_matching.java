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
	 * 在这个题里面，假设我们维护一个布尔数组res[i][j],代表s的前i个字符和p的前j个字符是否匹配(注意这里res的维度是s.length()+1,p.length()+1)。
	 * (1)p[j+1]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'.',也是相同），并且res[i][j]==true，则res[i+1][j+1]也为true，res[i+1][j+1]=false; 
	 * (2)p[j+1]是'*'，但是p[j]!='.'。那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true：
	 * 		1)res[i+1][j]为真（'*'只取前面字符一次; 
	 * 		2)res[i+1][j-1]为真（'*'前面字符一次都不取，也就是忽略这两个字符）;
	 * 		3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1]
	 * 		(这种情况是相当于i从0到s.length()扫过来，如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）
	 * (3)p[j+1]是'*'，并且p[j]=='.'。
	 * 因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]中只要有i+1是true，
	 * 那么剩下的res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]就都是true了。 
	 * 这道题有个很重要的点，就是实现的时候外层循环应该是p,然后待匹配串s内层循环扫过来。
	 */
	public boolean isMatch(String s, String p) {
		if (s.length() == 0 && p.length() == 0)
			return true;
		if (p.length() == 0)
			return false;
		boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
		res[0][0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '*') {
				if (j > 0 && res[0][j - 1]) res[0][j + 1] = true;
				if (j < 1) continue;
				if (p.charAt(j - 1) != '.') {
					for (int i = 0; i < s.length(); i++) {
						if (res[i + 1][j] || j > 0 && res[i + 1][j - 1] || i > 0 && j > 0 && res[i][j + 1]
								&& s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1))
							res[i + 1][j + 1] = true;
					}
				} else {
					int i = 0;
					while (j > 0 && i < s.length() && !res[i + 1][j - 1] && !res[i + 1][j])
						i++;
					for (; i < s.length(); i++) {
						res[i + 1][j + 1] = true;
					}
				}
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
						res[i + 1][j + 1] = res[i][j];
				}
			}
		}
		return res[s.length()][p.length()];
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
