package Lec11;

public class LexicographicallyCounting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lexicoCounting(1000, 0);

	}

	public static void lexicoCounting(int n, int num) {
		if(num>n)
			return;
		System.out.println(num);
		int i = 0;
		if(num == 0) {
			i=1;
		}
		for (; i <= 9; i++) {
			lexicoCounting(n, num * 10 + i);
		}

	}

}
