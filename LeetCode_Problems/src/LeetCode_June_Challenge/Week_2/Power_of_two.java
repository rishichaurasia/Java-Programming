package LeetCode_June_Challenge.Week_2;

public class Power_of_two {
	
	public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n & (n-1)) == 0;
    }
	
}
