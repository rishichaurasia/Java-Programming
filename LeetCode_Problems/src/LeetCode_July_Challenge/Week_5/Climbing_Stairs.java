package LeetCode_July_Challenge.Week_5;

public class Climbing_Stairs {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(climbStairs(n));
		System.out.println(climbStairs1(n));

	}
	
	public static int climbStairs(int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        int ans1 = climbStairs(n-1);
        int ans2 = climbStairs(n-2);
        return ans1+ans2;
    }
	
	public static int climbStairs1(int n) {
		int nminus1 = 3;
        int nminus2 = 2;
        int nth = n;
        for(int i = 4; i<=n; i++){
            nth = nminus1 + nminus2;
            nminus2 = nminus1;
            nminus1 = nth;
        }
        return nth;
    }

}
