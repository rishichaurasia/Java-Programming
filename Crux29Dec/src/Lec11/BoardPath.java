package Lec11;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printBoardPath(0, 10, ""));

	}

	public static int printBoardPath(int s, int e, String ans) {
		if (s == e) {
			System.out.println(ans);
			return 1;
		}
		if (s > e)
			return 0;
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count += printBoardPath(s + i, e, ans + i);
		}
		return count;

	}

}
