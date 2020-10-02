package August_Long_Challenge;

import java.util.Scanner;

public class Another_Card_Game_Problem {

	static Scanner scn = new Scanner(System.in);

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws java.lang.Exception {
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			solve();
		}
		System.out.println(result);
	}

	public static void solve() {

		String[] input = scn.nextLine().split(" ");
		int pc = Integer.parseInt(input[0]);
		int pr = Integer.parseInt(input[1]);
		
		int nc = (int)Math.ceil((double)pc/9);
		int nr = (int)Math.ceil((double)pr/9);
		String ans = nc < nr ? "0 " + nc : "1 " + nr;
		result.append(ans + "\n");
	}

}
