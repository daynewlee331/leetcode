package leetcode;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
	public static void main(String[] args){
		spiral_matrix sm = new spiral_matrix();
		int[][] test = {{2,5},{8,4},{0,-1}};
		sm.spiralOrder(test);
	}
	//leetcode 59. Spiral Matrix II
	public int[][] generateMatrix(int n) {
		if(n < 0) return null;
        if(n < 1) return new int[0][0];
        int[][] res = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int count = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
        	//traverse right
        	for(int j = colBegin; j <= colEnd; j ++){
        		res[rowBegin][j] = count;
        		count ++;
        	}
        	rowBegin ++;
        	
        	//traverse down
        	for(int i = rowBegin; i <= rowEnd; i ++){
        		res[i][colEnd] = count;
        		count ++;
        	}
        	colEnd --;
        	
        	//traverse left
        	if(rowBegin <= rowEnd){
        		for(int j = colEnd; j >= colBegin; j --){
        			res[rowEnd][j] = count;
        			count ++;
        		}
        	}
        	rowEnd --;
        	
        	//traverse up
        	if(colBegin <= colEnd){
        		for(int i = rowEnd; i <= rowBegin; i --){
        			res[i][colBegin] = count;
        			count ++;
        		}
        	}
        	colBegin ++;
        }
        return res;
    }
	
	//leetcode 54. Spiral Matrix
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length < 1) return res;
        int rowBegin = 0; 
        int colEnd = matrix[0].length - 1; 
        int rowEnd = matrix.length - 1; 
        int colBegin = 0;  
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
        	//traverse right
    		for(int j = colBegin; j <= colEnd; j ++){
            	res.add(matrix[rowBegin][j]);
            }
    		rowBegin ++;
    		
    		//traverse down
            for(int i = rowBegin; i <= rowEnd; i ++){
            	res.add(matrix[i][colEnd]);
            }
            colEnd --;
            
            //traverse left
            if(rowBegin <= rowEnd){
            	for(int j = colEnd; j >= colBegin; j --){
                	res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd --;
            
            if(colBegin <= colEnd){
            	//traverse up
            	for(int i = rowEnd; i >= rowBegin; i --){
                	res.add(matrix[i][colBegin]);
                }
            }
        	colBegin ++;
        }
        return res;
    }
}
