package Facebook_Hacker_Cup_2020.Qualification_Round;

import java.util.Scanner;

public class ProblemA_Travel_Restrictions {

	static Scanner scn = new Scanner(System.in);

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int t = scn.nextInt();
		int i = 1;
		while (t-- > 0) {
			sb.append("Case #" + i++ + ":\n");
			solve();
		}
		System.out.println(sb);

	}

	private static void solve() {

		int N = scn.nextInt();
		StringBuilder I = new StringBuilder(scn.next());
		StringBuilder O = new StringBuilder(scn.next());

		char[][] array = new char[N][N];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (i == j || (Math.abs(i - j) == 1 && O.charAt(i) == 'Y' && I.charAt(j) == 'Y'))
					array[i][j] = 'Y';
				else
					array[i][j] = 'N';

			}

		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (array[i][j] != 'Y' && array[i][k] == 'Y' && array[k][j] == 'Y')
						array[i][j] = 'Y';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(array[i]);
			sb.append("\n");
		}

	}

}
