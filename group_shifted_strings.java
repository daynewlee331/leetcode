package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class group_shifted_strings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String st: strings){
			int offset = st.charAt(0) - 'a';
			String key = "";
			for(int i = 0; i < st.length(); i ++){
				char c = (char) (st.charAt(i) - offset);
				if( c - 'a' < 0) c += 26;
				key += c;
			}
			if(!map.containsKey(key)){
				List<String> list = new ArrayList<String>();
				map.put(key, list);
			}
			map.get(key).add(st);
		}
		for(String key: map.keySet()){
			List<String> tmp = map.get(key);
			Collections.sort(tmp);
			res.add(tmp);
		}
		return res;
    }
}
