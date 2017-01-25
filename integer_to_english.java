package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class integer_to_english {
	public static void main(String[] args){
		integer_to_english ie = new integer_to_english();
	}
	private String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] tens = {"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] thousands = {"","","Thousand", "Million", "Billion"};
	private String[] hundreds = {"","One Hundred","Two Hundred","Three Hundred","Four Hundred","Five Hundred","Six Hundred","Seven Hundred","Eight Hundred","Nine Hundred"};	
	
    public String numberToWords(int num) {
		if(num == 0) return "Zero";
		Stack<String> stack = new Stack<String>();
		while(num != 0){
			String digits = threeDigits(num % 1000);
			stack.push(digits);
			num /= 1000;
		}
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()){
			int k = stack.size();
			String digits = stack.pop();
			if(!digits.equals("")){
				res.append(digits);
				res.append(" ");
				res.append(thousands[k]);
				res.append(" ");
			}
		}
		
		return res.toString().trim();
	}
	
	public String threeDigits(int num){
		if(num <= 99) return twoDigits(num);
		int tmp1 = num % 100;
		String res = hundreds[num / 100];
		return tmp1 == 0? res : res + " " + twoDigits(tmp1); 
	}
	
	public String twoDigits(int num){
		if(num < 20) return lessThan20[num];
		int tmp1 = num / 10;
		int tmp2 = num % 10;
		return tmp2 ==0 ?tens[tmp1] : tens[tmp1] + " " + lessThan20[tmp2];
	}
}
