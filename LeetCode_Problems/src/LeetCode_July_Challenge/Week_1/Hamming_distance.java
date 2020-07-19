package LeetCode_July_Challenge.Week_1;

public class Hamming_distance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(12, 121));

	}
	
	public static int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z>0){
            if((z&1) == 1) ++count;
            z>>=1;
        }
        return count;
    }

}
