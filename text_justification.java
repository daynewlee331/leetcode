package leetcode;

import java.util.ArrayList;
import java.util.List;

public class text_justification {
	public static void main(String[] args){
		text_justification tj = new text_justification();
		//String[] test = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] test = {"What","must","be","shall","be."};
		List<String> res = tj.fullJustify(test, 12);
		System.out.println();
	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) return res;
        int curL = 0;
        int count = 0;
        //boolean oneWordLeft = false;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> buffer = new ArrayList<String>();
        for(int i = 0; i < words.length; i ++){
        	if(curL + words[i].length() + count <= maxWidth){
        		buffer.add(words[i]);
        		curL += words[i].length();
        		count ++;
			} else {
				//TODO
				if(count == 1){//only a single word
					int tmp = maxWidth - curL;
					sb.append(buffer.get(0));
					for(int j = 0; j < tmp; j ++){
						sb.append(" ");
					}
				}else{
					int tmp = (maxWidth - curL) / (count - 1);
					int m = (maxWidth - curL) % (count - 1);
					for(int j = 0; j < buffer.size(); j ++){
						int nspace = (j + 1) <= m ? tmp+1 : tmp;
						if(j != buffer.size() - 1){
							sb.append(buffer.get(j));
							for(int k = 0; k < nspace; k ++){
								sb.append(" ");
							}
						}else{
							sb.append(buffer.get(j));
						}
					}
				}
				
				res.add(sb.toString());
				// clear everything
				curL = 0;
				buffer = new ArrayList<String>();
				sb = new StringBuilder();
				buffer.add(words[i]);
				curL = words[i].length();
				count = 1;
				/*
				if(i == words.length - 1){
					oneWordLeft = true;
				}*/
        	}
        }
		if (buffer.size() == 1) {
			int tmp = maxWidth - curL;
			sb.append(buffer.get(0));
			for (int j = 0; j < tmp; j++) {
				sb.append(" ");
			}
			res.add(sb.toString());
		} else if (buffer.size() > 1) {
			for (int j = 0; j < buffer.size(); j++) {
				if (j != buffer.size() - 1) {
					sb.append(buffer.get(j));
					sb.append(" ");
				} else {
					sb.append(buffer.get(j));
				}
			}
			int tmp = maxWidth - sb.length();
			for (int k = 0; k < tmp; k++) {
				sb.append(" ");
			}
			res.add(sb.toString());
		}
        return res;
    }
}
