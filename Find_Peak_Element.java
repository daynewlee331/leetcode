package leetcode;

public class Find_Peak_Element {
	/*
	 * If num[i-1] < num[i] > num[i+1], then num[i] is peak
	 * If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
	 * If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
	 * If num[i-1] > num[i] < num[i+1], then both sides have peak
	 * (n is num.length)
	 * 
	 * */
	public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
	
	public int find(int[] nums, int left, int right){
		if(left == right) return left;
		else if(left + 1 == right){
			return nums[left] > nums[right]? left : right;
		}else{
			int mid = (right - left) / 2 + left;
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
			else if(nums[mid + 1] < nums[mid] && nums[mid] < nums[mid - 1] ) {
				return find(nums, left, mid - 1);
			}else{
				return find(nums, mid + 1, right);
			}
		}
	}
}
