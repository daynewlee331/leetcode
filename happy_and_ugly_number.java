package leetcode;

import java.util.HashSet;

public class happy_and_ugly_number {
	//leetcode 202. Happy Number
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
        while(set.add(n)){
        	int sum = 0;
        	while(n > 0){
        		int tmp = n % 10;
        		sum += tmp * tmp;
        		n = n / 10;
        	}
        	if(sum == 1) return true;
        	else n = sum;
        }
        return false;
    }
	
	//leetcode 263. Ugly Number
	 public boolean isUgly(int num) {
		 if(num > 0){
			 while(num % 3 == 0) num = num / 3;
			 
			 while(num % 5 == 0) num = num / 5;
			 
			 while(num % 2 == 0) num = num / 2;
		 }
		 return num == 1;
	 }
}
