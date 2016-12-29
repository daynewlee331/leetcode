package leetcode;

public class multiply_add_strings {
	public static void main(String[] args){
		multiply_add_strings mas = new multiply_add_strings();
		//mas.multiply("97", "385");
		String test = mas.addStrings("999", "10");
		System.out.println(test);
	}
	
	//leetcode 43. Multiply Strings
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
	    int len2 = num2.length();
	    int[] product = new int[len1 + len2];
	    for (int i = len1 - 1; i >= 0; i--) {
	        for (int j = len2 - 1; j >= 0; j--) {
	            int index = len1 + len2 - i - j - 2;
	            product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
	            product[index + 1] += product[index] / 10;
	            product[index] %= 10;
	        }
	    }
	    StringBuilder builder = new StringBuilder();
	    for(int k = product.length - 1; k > 0; k --){
	    	if(builder.length() == 0 && product[k] == 0) continue;
	    	builder.append(product[k]);
	    }
	    builder.append(product[0]);
	    return builder.toString();
    }
	
	//leetcode 415. Add Strings
	public String addStrings(String num1, String num2) {
        int len1 = num1.length(); int len2 = num2.length();
        int i = len1 - 1; int j = len2 - 1;
        int carryOn = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 && j >= 0){
        	int a = num1.charAt(i) - '0'; 
        	int b = num2.charAt(j) - '0';
        	builder.append((a + b + carryOn) % 10);
        	carryOn = (a + b + carryOn) / 10;
        	i --;
        	j --;
        }
        
        while(i >= 0){
        	int a = num1.charAt(i) - '0'; 
        	builder.append((a + carryOn) % 10);
        	carryOn = (a + carryOn) / 10;
        	i --;
        }
        
        while(j >= 0){
        	int b = num2.charAt(j) - '0';
        	builder.append((b + carryOn) % 10);
        	carryOn = (b + carryOn) / 10;
        	j --;
        }
        
        return carryOn == 1? builder.append(1).reverse().toString(): builder.reverse().toString();
    }
}
