package leetcode;

import java.util.ArrayList;


public class print_all_path_in_tree {
	public static void main(String[] args){
		print_all_path_in_tree obj = new print_all_path_in_tree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		obj.printPath(root);
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
