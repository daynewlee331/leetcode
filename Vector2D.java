package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	public static void main(String[] args){
		List<List<Integer>> vec = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(1);
		row1.add(2);

		vec.add(row1);
		List<Integer> row3 = new ArrayList<>();
		vec.add(row3);

		List<Integer> row4 = new ArrayList<>();
		row4.add(3);
		vec.add(row4);
		
		List<Integer> row2 = new ArrayList<>();
		row2.add(4);
		row2.add(5);
		vec.add(row2);
		
		Vector2D sol = new Vector2D(vec);
		while (sol.hasNext()) {
			int result = sol.next();
			System.out.print(result + " * ");
			if(result == 2){
				sol.remove();
			}
		}
		System.out.println();
		for (List<Integer> row : vec) {
			for (Integer elem : row) {
				System.out.print(elem + " # ");
			}
		}
	}
	
	List<List<Integer>> buffer = null;
	int col = 0;
	int row = 0;
	public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.size() < 0) return;
        this.buffer = vec2d;
        this.row = 0;
        this.col = 0;
        while(this.row < this.buffer.size() && this.buffer.get(row).size() == 0) this.row ++;
    }

    @Override
    public Integer next() {
        int res = this.buffer.get(row).get(col);
        this.col ++;
        return res;
    }

    @Override
    public boolean hasNext() {
    	if(this.row >= this.buffer.size()) return false;
        if(this.col < this.buffer.get(row).size()) return true;
        this.row ++;
        this.col = 0;
        while(this.row < this.buffer.size() && this.buffer.get(row).size() == 0) this.row ++;
        return this.row < this.buffer.size();
    }
    
  //airbnb required method
  	//case1: the element is in current row
  	//case2: the element is in one of the previous rows
      public void remove(){
      	if(this.col - 1 >= 0) this.buffer.get(row).remove(this.col - 1);
      	else{
      		int tmp = this.row - 1;
          	while(tmp >= 0 && this.buffer.get(tmp).size() == 0) tmp --;
          	if(tmp < 0) return;
          	this.buffer.get(tmp).remove(this.buffer.get(tmp).size() - 1);
      	}
      	if(this.col > 0) this.col --;
      }
}
