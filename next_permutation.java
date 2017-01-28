package leetcode;

public class next_permutation {
	public static void main(String[] args){
		next_permutation sol = new next_permutation();
		sol.nextPermutation(new int[]{1,2,3});
	}
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 1) return;
        int i = nums.length - 2;
        //find the first one which breaks the ascending order from LEAST significant digit
        while(i >= 0 && nums[i] >= nums[i + 1]) i --;
        if(i >= 0){
        	int j = nums.length - 1;
        	while(nums[j] <= nums[i]) j --; // find the rightmost one which is bigger than a[i]
        	swap(nums, i , j);
        }
        reverse(nums, i + 1, nums.length - 1); //change it to descending order
    }
	
	public void swap(int a[], int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public void reverse(int[] a, int i, int j){
		while(i < j){
			swap(a, i, j);
			i ++;
			j --;
		}
	}
}
