package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class integer_to_english {
	public static void main(String[] args){
		integer_to_english ie = new integer_to_english();
		System.out.println(ie.two_digits(0));
	}
	private String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] tens = {"*","*","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] scale = {"","","Thousand", "Million", "Billion"};
	private String[] hundreds = {"","One Hundred","Two Hundred","Three Hundred","Four Hundred","Five Hundred","Six Hundred","Seven Hundred","Eight Hundred","Nine Hundred"};	
	
	public String numberToWords(int num) {
		if(num == 0) return "Zero";
        
        Stack<Integer> stack = new Stack<Integer>();
        while(num > 0){
        	int tmp = num % 1000;
        	num = num / 1000;
        	stack.add(tmp);
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
        	int size = stack.size();
        	int st = stack.pop();
        	String digits = three_digits(st);
        	res.append(digits);
        	if(size - 1 != 0 && digits!= "") res.append(" ");
        	if(digits != "")res.append(scale[size]);
        	if(size - 1 != 0 && digits!= "") res.append(" ");
        }
        return res.toString().trim();
    }
	
	public String three_digits(int num){
		if(num > 99){
			String digits = two_digits(num % 100);
			return digits.equals("")? hundreds[num / 100]: hundreds[num / 100] + " " + digits;
		}else{
			return two_digits(num);
		}
	}
	
	public String two_digits(int num){
		if(num < 20){
			return this.lessThan20[num];
		}else{
			String digit = lessThan20[num % 10];
    		return digit.equals("")? tens[num / 10]: tens[num / 10] + " " + digit;
		}
	}
}
