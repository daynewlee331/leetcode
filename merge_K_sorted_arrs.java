package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge_K_sorted_arrs {
	class Element{
		int val;
		int listIndex;
		int arrIndex;
		
		Element(int val, int x, int y){
			this.val = val;
			this.listIndex = x;
			this.arrIndex = y;
		}
	}
	
	public static void main(String[] args){
		merge_K_sorted_arrs sol = new merge_K_sorted_arrs();
		int[][] tes = {{1,3,5,7,},{2,8,11,19},{0,4,6,10}};
		int[] aws = sol.mergeKSortedArray(tes);
		for(int i = 0 ; i < aws.length ; i++){
            System.out.print(aws[i] + " ");
        }
	}
	
	public int[] mergeKSortedArray(int[][] arr){
		int m = arr.length;
		int n = arr[0].length;
		int[] res = new int[m * n];
		int k = 0;
		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		
		for(int i = 0; i < m; i ++){
			pq.offer(new Element(arr[i][0], i, 0));
		}
		
		while(!pq.isEmpty()){
			Element e = pq.poll();
			res[k] = e.val;
			int x = e.listIndex;
			int y = e.arrIndex + 1;
			if(y < n){
				pq.offer(new Element(arr[x][y], x, y));
			}
			k ++;
		}
		return res;
	}
	
	public int[] standardMergeKSortedArray(int[][] array){
        int m = array.length;
        int n = array[0].length;
        int[] res = new int[m*n];
        int index = 0;
        
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>(){
        	@Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)<o2.get(0)) return -1;
                else if(o1.get(0)==o2.get(0)) return 0;
                else return 1;
            }
        });

        for( int i = 0 ; i < array.length ; i++ ){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(array[i][0]);
            tempList.add(n*i);
            heap.add(new ArrayList<>(tempList));
        }
        while(!heap.isEmpty()){
            List<Integer> list = heap.poll();
            int val = list.get(0);
            res[index++] = val;
            int pos = list.get(1);
            int posY = pos / n;
            int posX = pos % n;
            if( posX + 1 < n ) {
                List<Integer> newList = new ArrayList<>();
                newList.add(array[posY][posX+1]);
                newList.add(posY*n + posX +1);
                heap.add(newList);
            }
        }
        return res;
    }
}
