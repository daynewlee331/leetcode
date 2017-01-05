package leetcode;

import java.util.ArrayList;
import java.util.List;

public class factor_combinations {
	//leetcode: 254. Factor Combinations
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n <= 3) return res;
		getFactorsHelper(res, new ArrayList<Integer>(), n, 2);
		return res;
    }
	
	public void getFactorsHelper(List<List<Integer>> res, List<Integer> cur, int n, int start){
		if(n <= 1){
			if(cur.size() > 1) {
			    res.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		for(int i = start; i <= n; i ++){
			if(n % i == 0){
				cur.add(i);
				getFactorsHelper(res, cur, n / i, i);
				cur.remove(cur.size() - 1);
			}
		}
	}
}
