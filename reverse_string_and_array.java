package leetcode;

public class reverse_string_and_array {
	public static void main(String[] args){
		reverse_string_and_array rs = new reverse_string_and_array();
		String s = "the sky is blue";
		char[] test = s.toCharArray();
		rs.reverseWords(test);
		System.out.println(String.valueOf(test));
	}
	
	//leetcode: 186. Reverse Words in a String II
	public void reverseWords(char[] s) {
        if(s == null || s.length < 1) return;
        reverse(0, s.length - 1, s);
        int i = 0; int j = 0;
        while(j < s.length){
        	if(j == s.length - 1){
    			reverse(i, j, s);
    			break;
        	}
        	if(s[j] == ' '){
        		reverse(i, j - 1, s);
        		i = j + 1;
        	}
        	j ++;
        }
    }
	
	public void reverse(int i, int j, char[] s){
		int p = i;
		int q = j;
		while(p < q){
			char tmp = s[p];
			s[p] = s[q];
			s[q] = tmp;
			p ++;
			q --;
		}
	}
	
	//leeetcode: 189. Rotate Array
	public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 1) return;
        k %= nums.length;
        rotate(0, nums.length - 1, nums);
        rotate(0, k - 1, nums);
        rotate(k, nums.length - 1, nums);
    }
	
	public void rotate(int i, int j, int[] arr){
		int p = i;
		int q = j;
		
		while(p < q){
			int tmp = arr[p];
			arr[p] = arr[q];
			arr[q] = tmp;
			p ++;
			q --;
		}
	}
}
