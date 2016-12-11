package leetcode;

import java.util.Random;

public class random_pick_index {
	int count = 0;
    Random rand = null;
    int[] nums = null;
    public random_pick_index(int[] nums) {
        this.nums = nums;
        this.count = 0;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target){
                if(rand.nextInt(count) == 0){
                    res = i;
                }
                count ++;
            }
        }
        return res;
    }
}
