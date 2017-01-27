package leetcode;

public class add_binary {
	public static void main(String[] args){
		add_binary ab = new add_binary();
		String test = ab.addBinary("11", "11");
		System.out.println(test);
		
	}
	
	public String addBinary(String a, String b) {
		if(a == null || b == null) return "";
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int carryOn = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 && j >= 0){
        	int tmp = c1[i] - '0' + c2[j] - '0' + carryOn;
        	builder.append(tmp % 2);
        	carryOn = tmp / 2;
        	i --;
        	j --;
        }
        
        while(i >= 0){
        	int tmp = c1[i] - '0' + carryOn;
        	builder.append(tmp % 2);
        	carryOn = tmp / 2;
        	i --;
        }
        
        while(j >= 0){
        	int tmp = c2[j] - '0' + carryOn;
        	builder.append(tmp % 2);
        	carryOn = tmp / 2;
        	j --;
        }
        
        if(carryOn == 1) builder.append(1);
        return builder.reverse().toString();
    }
}
