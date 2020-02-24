package Lec14;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calcPower(2, 6));

	}
	
	public static int calcPower(int x, int n) {
		if(n==0)
			return 1;
		int rr = calcPower(x, n/2);
		if(n%2==0)
			return rr * rr;
		else
			return rr * rr * x;
	}

}
