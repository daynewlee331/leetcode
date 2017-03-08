package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class find_rectangle {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
			{1,1,1,1,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,0,0,1,1,1,1},
			{1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1}
		};
		find_rectangle sol = new find_rectangle();
		int[] test = sol.findDiagnose(matrix);
		System.out.println(test[0] + " " + test[1] + " " + test[2] + " " + test[3]);
	}
	
	public int[] findDiagnose(int[][] matrix){
		if(matrix == null || matrix.length < 1) return new int[]{-1,-1,-1,-1};
		int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
		for(int i = 0; i < matrix.length; i ++){
			for(int j = 0; j < matrix[0].length; j ++){
				if(matrix[i][j] == 0 && row1 == -1 && col1 == -1){
					row1 = i;
					col1 = j;
				}
			}
			if(row1 > -1 && col1 > -1) break;
		}
		
		for(int i = matrix.length - 1; i >= 0; i --){
			for(int j = matrix[0].length - 1; j >= 0; j --){
				if(matrix[i][j] == 0 && row2 == -1 && col2 == -1) {
					row2 = i;
					col2 = j;
				}
			}
			if(row2 > -1 && col2 > -1) break;
		}
		
		return new int[]{row1, col1, row2, col2};
	}
	
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
