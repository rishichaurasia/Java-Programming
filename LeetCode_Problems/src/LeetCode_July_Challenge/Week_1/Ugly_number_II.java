package LeetCode_July_Challenge.Week_1;

public class Ugly_number_II {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(12));

	}
	
	public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2, idx3, idx5;
        idx2 = idx3 = idx5 = 0;
        int count = 1;
        while(count < n){
            int next2 = ugly[idx2]*2;
            int next3 = ugly[idx3]*3;
            int next5 = ugly[idx5]*5;
            int min = Math.min(next2, Math.min(next3,next5));
            ugly[count++] = min;
            if(min == next2)
                ++idx2;
            if(min == next3)
                ++idx3;
            if(min == next5)
                ++idx5;
        }
        return ugly[n-1];
    }

}
