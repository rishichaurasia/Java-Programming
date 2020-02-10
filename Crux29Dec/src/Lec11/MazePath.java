package Lec11;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMazePath(0, 0, 2, 4, "");
//		printMazePath1(0,0, 2,4, "");

	}

	public static void printMazePath(int sr, int sc, int er, int ec, String ans) {
		if (sr == er && sc == ec) {
			System.out.println(ans);
			return;
		}
		if (sr < er)
			printMazePath(sr + 1, sc, er, ec, ans + "V");
		if (sc < ec)
			printMazePath(sr, sc + 1, er, ec, ans + "H");
	}

	public static void printMazePath1(int sr, int sc, int er, int ec, String ans) {
		if (sr == er && sc == ec) {
			System.out.println(ans);
			return;
		}
		if (sc > ec || sr > er)
			return;
		printMazePath1(sr + 1, sc, er, ec, ans + "V");
		printMazePath1(sr, sc + 1, er, ec, ans + "H");
	}

}
