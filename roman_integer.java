package leetcode;

public class roman_integer {
	public static void main(String[] args){
		roman_integer ri = new roman_integer();
		int num = ri.romanToInt("IX");
		System.out.println(num);
	}
	
	public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'A'] = 1; map['X' - 'A'] = 10; map['C' - 'A'] = 100;
        map['V' - 'A'] = 5; map['L' - 'A'] = 50; map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        s += s.charAt(s.length() - 1);
        int res = 0;
        for(int i = 0; i + 1 < s.length(); i ++){
        	if(map[s.charAt(i) - 'A'] >= map[s.charAt(i + 1) - 'A']) 
        		res += map[s.charAt(i) - 'A'];
        	else res -= map[s.charAt(i) - 'A'];
        }
        
        return res;
    }
	
	public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i ++){
        	while(num >= values[i]){
        		sb.append(strs[i]);
        		num -= values[i];
        	}
        }
        return sb.toString();
    }
	
	
}
