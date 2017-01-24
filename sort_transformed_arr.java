package leetcode;

public class sort_transformed_arr {
	//leetcode 360 sort_transformed_arr
	public static void main(String[] args){
		sort_transformed_arr sol = new sort_transformed_arr();
		int[] test = sol.sortTransformedArray(new int[]{-4, -2, 2, 4}, 1,3,5);
		for(int num: test) System.out.print(num + " ");
		System.out.println();
		int[] test2 = sol.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1,3,5);
		for(int num: test2) System.out.print(num + " ");
	}
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		//1.a>0, two ends in original array are bigger than center if you learned middle school math before.
		//2.a<0, center is bigger than two ends.
		if(nums == null || nums.length < 1) return new int[0];
		if(nums.length == 1) return new int[]{nums[0]};
		int n = nums.length; int i = 0; int j =  n - 1;
		int[] res = new int[n];
		int index = n - 1;
		if(a < 0) index = 0;
		while(i <= j){
			if(a < 0){
				res[index ++] = transform(nums[i], a, b ,c) < transform(nums[j], a, b, c)? transform(nums[i ++], a, b ,c): transform(nums[j --], a, b, c);
			}else{
				res[index--] = transform(nums[i], a, b ,c) > transform(nums[j], a, b, c)? transform(nums[i ++], a, b ,c) : transform(nums[j --], a, b, c);
			}
		}
		return res;
	}
	
	public int transform(int x, int a, int b, int c){
		return a * x * x + b * x + c;
	}
}
