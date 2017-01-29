package leetcode;

import java.util.ArrayList;

public class random_index_max_element {
	public static void main(String[] args){
		random_index_max_element sol = new random_index_max_element();
		int[] a = {1,2,3,4,4,3,2,1,5,4,3,2,5,5,1};
		//sol.findMax(a);
		sol.findMaxIndex(a);
	}
	
	public int findMaxIndex(int[] A){
		if(A == null || A.length < 1) return -1;
		int max = A[0];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i < A.length; i ++){
			if(A[i] == max){
				list.add(i);
			}else if(A[i] > max){
				list.clear();
				list.add(i);
				max = A[i];
			}
		}
		
		int random = (int)Math.random() * list.size();
		return list.get(random);
	}
	
	public int findMax(int[] arr){
        if( arr == null || arr.length == 0 ) return -1;
        int max = arr[0];
        int index = 1;
        for ( int i = 1 ; i < arr.length ; i++){
            if( arr[i] == max ){
                int temp = arr[index];
                arr[index] = i;
                arr[i] = temp;
                index++;
            }
            else if( arr[i] > max ){
                max = arr[i];
                index = 0;
                int temp = arr[index];
                arr[index] = i;
                arr[i] = temp;
                index++;
            }
        }
        int random = (int)(Math.random()*index);
        return arr[random];
    }
}
