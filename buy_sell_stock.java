package leetcode;

public class buy_sell_stock {
	public static void main(String[] args){
		buy_sell_stock bs = new buy_sell_stock();
		int[] nums = {7, 1, 5, 3, 6, 4};
		bs.maxProfit_coolDown(nums);
	}
	
	//leetcode121
	//buy and sell stock with at most one transaction
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        int min = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i ++){
        	if(min >= prices[i]){
        		min = prices[i];
        	}else{
        		res = Math.max(res, prices[i] - min);
        	}
        }
        return res;
    }
	
	//leetcode 122
	//Best Time to Buy and Sell Stock II
	public int maxProfit2(int[] prices) {
		if(prices == null || prices.length < 1) return 0;
		int current = prices[0];
		int res = 0;
		for(int i = 1; i < prices.length; i ++){
			if(prices[i] > current){
				res += prices[i] - current;
			}
			current = prices[i];
		}
		return res;
    }
	
	//leetcode 309
	//Best Time to Buy and Sell Stock with Cooldown
	public int maxProfit_coolDown(int[] prices) {
		if(prices == null || prices.length < 1) return 0;
		int[] s0 = new int[prices.length];
		int[] s1 = new int[prices.length];
		int[] s2 = new int[prices.length];
		s0[0] = 0; // At the start, you don't have any stock if you just rest
		s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
		s2[0] = Integer.MIN_VALUE; // Lower base case
		for(int i = 1; i < prices.length; i ++){
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }
}
