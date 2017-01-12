package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class simplify_path {
	/*
	 * leetcode 71. Simplify Path
	 * 这是一道简化路径的题，路径简化的依据是：
	 * 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
	 * 当遇到"/./"则表示是本级目录，无需做任何特殊操作。 
	 * 当遇到"//"则表示是本级目录，无需做任何操作。
	 * 当遇到其他字符则表示是文件夹名，无需简化。
	 * 当字符串是空或者遇到”/../”，则需要返回一个"/"。
	 * 当遇见"/a//b"，则需要简化为"/a/b"。
	 * 
	 * 根据这些要求，我需要两个栈来解决问题。
	 * 先将字符串依"/"分割出来，然后检查每个分割出来的字符串。
	 * 当字符串为空或者为"."，不做任何操作.
	 * 当字符串不为".."，则将字符串入栈。
	 * 当字符串为"..", 则弹栈（返回上级目录）。
	 * */
	
	public static void main(String[] args){
		simplify_path sp = new simplify_path();
		String s = sp.simplifyPath("/abc/.../");
		System.out.println();
	}
	
	public String simplifyPathDeque(String path) {
		Deque<String> stack = new LinkedList<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("", ".", ".."));
		String[] arr = path.split("/");
		for(String st: arr){
			if(st.equals("..") && stack.size() > 0) stack.pop();
			else if(!skip.contains(st)) stack.push(st);
		}
		
		String res = "";
		for(String dir: stack){
			res = "/" + dir + res;
		}
		return res.length() == 0? "/" : res;
	}
	
	public String simplifyPath(String path) {
        if(path == null) return null;
        if(path.length() < 1) return "";
        String[] arr = path.split("/");
        Set<String> isSkip = new HashSet<>(Arrays.asList("", ".", ".."));
        Stack<String> stack = new Stack<String>();
        Stack<String> helper = new Stack<String>();
        for(String st: arr){
        	 if(st.equals("..") && !stack.isEmpty()) stack.pop();
        	 if(isSkip.contains(st)) continue;
        	 stack.push(st);
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
        	helper.push(stack.pop());
        }
        while(!helper.isEmpty()){
        	builder.append("/");
        	builder.append(helper.pop());
        }
        return builder.length() == 0? "/": builder.toString();
    }
}
