package leetcode;

public class longest_palindrom_substr {
	public static void main(String[] args){
		String s = "apple";
		System.out.println(s.substring(-1, 1));
	}
	
	public String longestPalindrome(String s) {
        if(s.length() < 1) return "";
        int len = 0;
        String res = "";
        for(int i = 0; i < s.length(); i ++){
        	if(isPalindrome(s, i - len - 1, i)){
        		res = s.substring(i - len - 1, i + 1);
        		len = len + 2;
        	}else if(isPalindrome(s, i - len, i)){
        		res = s.substring(i - len, i + 1);
        		len = len + 1;
        	}
        }
        return res;
    }
	
	public boolean isPalindrome(String s, int l, int r){
		if(l < 0) return false;
		if(l > r) return false;
		while(l < r){
			if(s.charAt(l ++) != s.charAt(r --)) return false;
		}
		return true;
	}
}
