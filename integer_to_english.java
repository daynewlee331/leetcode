package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class integer_to_english {
	public static void main(String[] args){
		integer_to_english ie = new integer_to_english();
		String test = ie.numberToWords(10540320);
		System.out.println(test);
	}
	private String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] tens = {"*","*","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] scale = {"","","Thousand", "Million", "Billion"};
	private String[] hundreds = {"","One Hundred","Two Hundred","Three Hundred","Four Hundred","Five Hundred","Six Hundred","Seven Hundred","Eight Hundred","Nine Hundred"};	
	
	public String numberToWords(int num) {
		if(num == 0) return "Zero";
        
        String s = num + "";
        Stack<String> stack = new Stack<String>();
        while(num > 0){
        	StringBuilder tmp = new StringBuilder();
        	tmp.append(num % 1000);
        	num = num / 1000;
        	stack.add(tmp.toString());
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
        	int size = stack.size();
        	String st = stack.pop();
        	String digits = three_digits(st);
        	res.append(digits);
        	if(size - 1 != 0 && digits!= "") res.append(" ");
        	if(digits != "")res.append(scale[size]);
        	if(size - 1 != 0 && digits!= "") res.append(" ");
        }
        return res.toString().trim();
    }
		
	public String three_digits(String num){
		if(num.length() > 3 || num.length() < 1) return null;
		if(Integer.parseInt(num) == 0) return "";
        
        char[] arr = num.toCharArray();
        if(arr.length == 3){
        	if(arr[0] == '0'){
        		return two_digits(arr[1] + "" + arr[2] );
        	}else{
        		String digits = two_digits(arr[1] + "" + arr[2]);
        		return digits.equals("")? hundreds[arr[0] - '0']: hundreds[arr[0] - '0'] + " " + two_digits(arr[1] + "" + arr[2]);
        	}
        }else if(arr.length == 2) {
        	return two_digits(arr[0] + "" +  arr[1]);
        }else{
        	return two_digits(arr[0] + "");
        }
	}
	
	public String two_digits(String num){
		if(num.length() > 2 || num.length() < 1) return null;
		if(Integer.parseInt(num) == 0) return "";
		char[] arr = num.toCharArray();
		
		if(Integer.parseInt(num) < 20){
			return this.lessThan20[Integer.parseInt(num)];
		}else{
			String digit = lessThan20[arr[1] - '0'];
    		return digit.equals("")? tens[arr[0] - '0']: tens[arr[0] - '0'] + " " + digit;
		}
	}
}
