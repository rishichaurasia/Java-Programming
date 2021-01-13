package Math;

public class SQRT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(1024));
	}
	
	public static double sqrt(double n) {
		double eps = 1e-6;
		double left = 0;
		double right = n;
		while(right - left >= eps) {
			double mid = left + (right-left)/2;
			double sq = mid*mid;
			if(sq == n)
				return mid;
			else if(sq < n+eps)
				left = mid+eps;
			else
				right = mid-eps;
		}
		return left;
	}

}
