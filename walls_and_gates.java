package leetcode;

public class walls_and_gates {
	public static void main(String[] args){
		int[][] test = {{2147483647, -1, 0, 2147483647}, 
						{2147483647, 2147483647, 2147483647, -1},
						{2147483647, -1, 2147483647, -1}, 
						{0, -1, 2147483647, 2147483647}};
		walls_and_gates wg = new walls_and_gates();
		wg.wallsAndGates(test);
		System.out.println();
	}
	
	//leetcode 286. Walls and Gates
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null) return;
        for(int i = 0; i < rooms.length; i ++){
        	for(int j = 0; j < rooms[0].length; j ++){
        		if(rooms[i][j] == 0){
        			helper(rooms, i, j, 0);
        		}
        	}
        }
    }
	
	public void helper(int[][] rooms, int i, int j, int distance){
		if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || distance > rooms[i][j]) return;//wall
		rooms[i][j] = distance;
		helper(rooms, i + 1, j, distance + 1);
		helper(rooms, i, j + 1, distance + 1);
		helper(rooms, i - 1, j, distance + 1);
		helper(rooms, i, j - 1, distance + 1);
	}
}
