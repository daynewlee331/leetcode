package leetcode;

import java.util.ArrayList;
import java.util.List;

public class text_justification {
	
	//leetcode 68
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		if(words == null || words.length < 1) return res;
		int charNum = 0;
		ArrayList<String> buffer = new ArrayList<String>();
		StringBuilder builder = null;
		for(int i = 0; i < words.length; i ++){
			if(charNum + buffer.size() + words[i].length() <= maxWidth){
				charNum += words[i].length();
				buffer.add(words[i]);
			}else{
				builder = new StringBuilder();
				if(buffer.size() == 1){
					int diff = maxWidth - charNum;
					builder.append(buffer.get(0));
					builder.append(generateSpaces(diff));
				}else{
					int avg = (maxWidth - charNum) / (buffer.size() - 1);
					int extra = (maxWidth - charNum) % (buffer.size() - 1);
					for(int j = 0; j < buffer.size(); j ++){
						int nspace = (j + 1) <= extra? avg + 1: avg;
						builder.append(buffer.get(j));
						if(j != buffer.size() - 1) builder.append(generateSpaces(nspace));
					}
				}
				res.add(builder.toString());
				buffer.clear();
				buffer.add(words[i]);
				charNum = words[i].length();
			}
		}
		
		builder = new StringBuilder();
		if(buffer.size() == 1){
			int diff = maxWidth - charNum;
			builder.append(buffer.get(0));
			builder.append(generateSpaces(diff));
			res.add(builder.toString());
		}else{
			int num = 0;
			for(int j = 0; j < buffer.size(); j ++){
				builder.append(buffer.get(j));
				num += buffer.get(j).length();
				builder.append(" ");
				num ++;
			}
			builder.append(generateSpaces(maxWidth - num));
			res.add(builder.toString());
		}
		return res;
    }
	
	public String generateSpaces(int num){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < num; i ++){
			builder.append(" ");
		}
		return builder.toString();
	}
}
