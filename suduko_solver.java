package leetcode;

public class suduko_solver {
	public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }
    
	public boolean solve(char[][] board) {
        for(int i = 0; i < 9; i ++){
        		for(int j = 0; j < 9; j ++){
        			if(board[i][j] == '.'){
        				for(char c = '1'; c <= '9'; c ++){
        					if(isValid(i, j, c, board)) {
            					board[i][j] = c;
            					if(solve(board)) return true;
            					else board[i][j] = '.';
        					}
        				}
        				return false;
        			}
        		}
        }
        return true;
    }
    
     private boolean isValid(int row, int col, char c, char[][] board){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
        }
        for (int p = (row / 3) * 3; p < (row / 3 + 1) * 3; p ++)
            for (int q = (col / 3) * 3; q < (col / 3 + 1) * 3; q ++)
                if (board[p][q] == c) return false;
        return true;
    }
}
