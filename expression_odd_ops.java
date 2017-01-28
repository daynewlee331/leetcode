package leetcode;

import java.util.ArrayList;
import java.util.List;

public class expression_odd_ops {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		if(num == null || num.length() < 1) return res;
		helper(res, 0, "", num, target, 0, 0);
		return res;
    }
	
	public void helper(List<String> res, int index, String path, String num, int target, long cur, long prev){
		if(index == num.length()){
			if(cur == target) res.add(path);
			return;
		}
		for(int i = index; i < num.length(); i ++){
			if(num.charAt(index) == '0' && i != index) break;
			Long tmp = Long.parseLong(num.substring(index, i + 1));
			if(index == 0){
				helper(res, i + 1, path + tmp, num, target, tmp, tmp);
			}else{
				/*
				 * multiplication: e.g. 2 + 3 * 4
				 * so far we got 2 + 3, so we have to do 5 - 3 + 3 * 4
				 * same approach also applies for: 2 + 3 * 4 * 5
				 * we have to do: 2 + 3 * 4 - 3 * 4 + 3 * 4 * 5
				 * */
				helper(res, i + 1, path + "+" + tmp, num, target, cur + tmp, tmp);
				helper(res, i + 1, path + "-" + tmp, num, target, cur - tmp, -tmp);
				helper(res, i + 1, path + "*" + tmp, num, target, cur - prev + prev * tmp , prev * tmp);
			}
		}
	}
}
