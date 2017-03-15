package leetcode;

public class next_permutation {
	public static void main(String[] args){
		next_permutation sol = new next_permutation();
		sol.nextPermutation(new int[]{1,2,3});
	}
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1) return;
        int index = -1, flag = -1;
        for(int i = nums.length - 1; i - 1 >= 0; i --){
        		if(nums[i - 1] < nums[i]) {
        			index = i - 1;
        			flag = i;
        			break;
        		}
        }
        if(index == -1) { reverse(nums, 0, nums.length - 1); return; }
        	for(int i = nums.length - 1; i >= 0; i --){
        		if(nums[i] > nums[index]) {
        			int tmp = nums[i];
        			nums[i] = nums[index];
        			nums[index] = tmp;
        			break;
        		}
        	}
        	reverse(nums, flag, nums.length - 1);
    }
	
	public void reverse(int[] nums, int left, int right){
		while(left < right){
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left ++;
			right --;
		}
	}
}
