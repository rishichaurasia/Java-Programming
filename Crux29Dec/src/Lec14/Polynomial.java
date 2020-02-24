package Lec14;

public class Polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computePoly(3, 5, 3));
	}

	public static int computePoly(int x, int n, int i) {
		if (n == 0)
			return 0;
		return i * n + computePoly(x, n - 1, i * x);
	}

}
