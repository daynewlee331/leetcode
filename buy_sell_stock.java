package leetcode;

public class buy_sell_stock {
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
}
