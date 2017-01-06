package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class k_pairs_with_smallest_sums {
	class Pair{
		int[] pair;
		int index; //current index of nums2
		long sum;
		Pair(int index, int n1, int n2){
			this.index = index;
			pair = new int[]{n1, n2};
			sum = (long)n1 + (long)n2;
		}
	}
	class Tuple{
		int row;
		int col;
		int val;
		Tuple(int row, int col, int val){
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	public static void main(String[] args){
		int[][] test = {{1,5,9},{10,11,13},{12,13,15}};
		k_pairs_with_smallest_sums obj = new k_pairs_with_smallest_sums();
		obj.kthSmallest(test, 8);
	}
	
	//leetcode378. Kth Smallest Element in a Sorted Matrix
	public int kthSmallest(int[][] matrix, int k) {
		
    }
	
	//leetcode 373. Find K Pairs with Smallest Sums
	 public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		 List<int[]> res = new ArrayList<int[]>();
		 if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) return res;
		 int length2 = nums2.length;
		 PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1.sum, o2.sum);
			}});
		 
		 for(int i = 0; i < nums1.length && i < k; i ++){
			 pq.offer(new Pair(0, nums1[i], nums2[0]));
		 }
		 
		 for(int j = 1; j <= k && !pq.isEmpty(); j ++){
			 Pair p = pq.poll();
			 res.add(p.pair);
			 if(p.index < length2 - 1){//make sure we are still in range
				 int next = p.index + 1;
				 pq.offer(new Pair(next, p.pair[0], nums2[next]));
			 }
		 }
		 return res;
	 }
}
