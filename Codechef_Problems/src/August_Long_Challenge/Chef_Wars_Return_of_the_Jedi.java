package August_Long_Challenge;

import java.util.Scanner;

public class Chef_Wars_Return_of_the_Jedi {

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
		int h = Integer.parseInt(input[0].trim());
		int p = Integer.parseInt(input[1].trim());

		int ans = h < 2*p ? 1:0;
		
		result.append(ans + "\n");
	}

}
