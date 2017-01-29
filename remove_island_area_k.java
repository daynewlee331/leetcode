package leetcode;

public class remove_island_area_k {
	public static void main(String[] args){
		char[][] n = {
                {'1','1','1','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'},
                {'1','1','0','1','0'},
        };
		remove_island_area_k sol = new remove_island_area_k();
        sol.removeIsland(n,3);

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
	}
	
	
	public void removeIsland(char[][] grid, int k){
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid[0].length; j ++){
				if(grid[i][j] == '1'){
					int[] size = new int[1];
					search(grid, i, j, size);
					if(size[0] > k) remove(grid, i, j);
				}
			}
		}
	}
	
	public void search(char[][] grid, int i, int j, int[] size){
		grid[i][j] = '*';
		size[0] ++;
		if(i - 1 >= 0 && grid[i - 1][j] == '1')
			search(grid, i - 1, j, size);
		if(i + 1 < grid.length && grid[i + 1][j] == '1')
			search(grid, i + 1, j, size);
		if(j - 1 >= 0 && grid[i][j - 1] == '1')
			search(grid, i, j - 1, size);
		if(j + 1 < grid[0].length &&  grid[i][j + 1] == '1')
			search(grid, i, j + 1, size);
	}
	
	public void remove(char[][] grid, int i, int j){
		grid[i][j] = '0';
		if(i - 1 >= 0 && grid[i - 1][j] == '*')
			remove(grid, i - 1, j);
		if(i + 1 < grid.length && grid[i + 1][j] == '*')
			remove(grid, i + 1, j);
		if(j - 1 >= 0 && grid[i][j - 1] == '*')
			remove(grid, i, j - 1);
		if(j + 1 < grid[0].length &&  grid[i][j + 1] == '*')
			remove(grid, i, j + 1);
	}
}
