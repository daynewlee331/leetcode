package leetcode;

public class str_Str {
	public static void main(String args[]){
		str_Str ss = new str_Str();
		int index = ss.strStr("a", "");
		System.out.println(index);
	}
	
	public int strStr(String haystack, String needle) {
		if(needle == null || haystack == null) return -1;
		if(needle.length() < 1) return 0;
		int i = 0; int j = 0;
        while(j < haystack.length()){
        	while(j < haystack.length() && j - i + 1 >= 0 && j - i + 1 < needle.length()) j ++;
        	if(j < haystack.length() && j - i + 1 == needle.length()){
        		if(haystack.substring(i, j + 1).equals(needle)) return i;
        		j ++;
        	}
        	while(j < haystack.length() && j - i + 1 >= 0 && j - i + 1 > needle.length()) i ++;
        }
        return -1;
    }
}
