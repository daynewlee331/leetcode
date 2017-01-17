package leetcode;

public class read4_solution {
	public int read(char[] buf, int n) {
		char[] buff = new char[4];
        int count = 0;
        while(count < n){
        	int num = read4(buff);
        	if(num == 0) break;
        	int i = 0;
        	while(i < num && count < n){
        		buf[count] = buff[i];
        		i ++;
        		count ++;
        	}
        }
        return count;
    }
	
	public int read4(char[] buffer){
		return 0;
	}
}
