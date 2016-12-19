package leetcode;

import java.util.ArrayList;

public class decode_ways {
	public static void main(String[] args){
		decode_ways dw = new decode_ways();
		dw.numDecodings("123");
	}
	
	public int numDecodings(String s) {
		char[] arr = s.toCharArray();
		if(s == null || s.length() < 1) return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = arr[0] == '0'? 0 : 1;
		for(int i = 2; i <= s.length(); i ++){
			int oneDigit = Integer.parseInt(s.substring(i - 1, i));
			int twoDigits = Integer.parseInt(s.substring(i - 2, i));
			if(oneDigit >= 1 && oneDigit <= 9) dp[i] += dp[i - 1];
			if(twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2];
		}
		return dp[s.length()];
    }
	
}
