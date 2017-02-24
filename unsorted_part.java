package leetcode;
import java.util.Arrays;

public class unsorted_part {
	public static void main(String[] args){
		unsorted_part sol = new unsorted_part();
		int ans = sol.unsortedLength(new int[]{});
		System.out.println(ans);
	}
	public int unsortedLength(int[] nums){
		if(nums == null || nums.length <= 1) return 0;
		int[] copy = new int[nums.length];
		for(int i = 0; i < nums.length; i ++) copy[i] = nums[i];
		Arrays.sort(copy);
		int left = 0, right = nums.length - 1;
		while(left < right){
			while(left < right && nums[left] == copy[left]) left ++;
			while(left < right && nums[right] == copy[right]) right --;
			if(nums[left] != copy[left] && nums[right] != copy[right]) return right - left + 1;
		}
		return 0;
	}
}
