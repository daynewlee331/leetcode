package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class print_all_path_in_tree {
	public static void main(String[] args){
		print_all_path_in_tree obj = new print_all_path_in_tree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		obj.printAllPath(root);
	}
	
	public void printAllPath(TreeNode root){
		if(root == null) return;
		Queue<Object> queue = new LinkedList<Object>();
		queue.add(root);
		queue.add(root.val + "");
		while(!queue.isEmpty()){
			TreeNode cur = (TreeNode)queue.poll();
			String path = (String) queue.poll();
			if(cur.left == null && cur.right == null){
				System.out.println(path);
				continue;
			}
			if(cur.left != null){
				String left = path + "->" + cur.left.val;
				queue.offer(cur.left);
				queue.offer(left);
			}
			if(cur.right != null){
				String right = path + "->" + cur.right.val;
				queue.offer(cur.right);
				queue.offer(right);
			}
		}
	}
	
	public void printPath(TreeNode root){
		printPathRec(root, 0, new ArrayList<Integer>());
	}
	
	public void printPathRec(TreeNode root, int pathLen, ArrayList<Integer> list){
		if(root == null) return;
		list.add(pathLen, root.val);
		pathLen ++;
		if(root.left == null && root.right == null) print(list, pathLen);
		else{
			printPathRec(root.left, pathLen, list);
			printPathRec(root.right, pathLen, list);
		}
	}
	
	public void print(ArrayList<Integer> list, int len){
		for(int i = 0; i < len; i ++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}
