package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class find_rectangle {
	public static void main(String[] args){
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(Arrays.asList(1,3));
		System.out.println(set.contains(Arrays.asList(1,3)));
		
		int[][] matrix = new int[][]{
			{1,1,1,0},
			{1,1,1,0},
			{1,1,1,0},
			{1,1,1,0}
		};
		find_rectangle sol = new find_rectangle();
		int[] arr = sol.findRectangle(matrix);
		for(int num: arr) System.out.print(num + " ");
	}
	
	/*
	public int[] findRectangleRec(int[][] matrix){
		
	}*/
	
	public int[] findRectangle(int[][] matrix){
		if(matrix == null || matrix.length < 1) return new int[]{-1,-1,0,0};
		int row = -1;
		int col = -1;
		int length = 0;
		int width = 0;
		int curRow = -1;
		for(int i = 0; i < matrix.length; i ++){
			int tmp = 0;
			for(int j = 0; j < matrix[0].length; j ++){
				if(matrix[i][j] == 0 && row == -1 && col == -1){
					row = i;
					col = j;
				}
				if(matrix[i][j] == 0){
					if(i != curRow) {
						width ++;
						curRow = i;
					}
					tmp ++;
					length = Math.max(tmp, length);
				}
			}
		}
		return new int[]{row, col, length, width};
	}
}
