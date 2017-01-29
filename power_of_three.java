package leetcode;

public class power_of_three {
	public static void main(String[] args){
		System.out.println(Math.log10(4));
		System.out.println(Math.log10(4)/ Math.log10(3));
	}
	
	public boolean isPowerOfThree(int n) {
		return (Math.log10(n)/ Math.log10(3)) % 1 == 0;
	}
}
