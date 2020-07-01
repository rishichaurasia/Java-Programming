package Dynamic_Programming;

/*
 * To find the minimum number of multiplication operations needed to multiply the matrices of 
 * given chain order.
 */
public class Matrix_Chain_Multiplication {

	public static void main(String[] args) {
		int[] matrix = {4,2,3,5,1};
//		int[] matrix = new int[1000];
//		for (int i = 0; i < 1000; i++)
//			matrix[i] = i + 1;
		int n = matrix.length;
//		System.out.println(MCMRecur(matrix, 0, n-1));
		System.out.println(MCMTD(matrix, 0, n - 1, new int[n][n]));
		System.out.println(MCMBU(matrix));

	}

//	O(n! * 2^n) Time  | O(1) space
	private static int MCMRecur(int[] matrix, int si, int ei) {
		if (si + 1 == ei)
			return 0;
		int minOperations = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {
			int part1 = MCMRecur(matrix, si, k); // matrix[si] * matrix[k]
			int part2 = MCMRecur(matrix, k, ei); // matrix[k] * matrix[ei]

			int whole = matrix[si] * matrix[k] * matrix[ei]; // matrix[si] * matrix[ei]

			int totalOperations = part1 + part2 + whole;
			minOperations = Math.min(minOperations, totalOperations);
		}
		return minOperations;
	}

	private static int MCMTD(int[] matrix, int si, int ei, int[][] strg) {
		if (si + 1 == ei)
			return 0;
		if (strg[si][ei] != 0)
			return strg[si][ei];

		int minOperations = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {
			int part1 = MCMTD(matrix, si, k, strg); // matrix[si] * matrix[k]
			int part2 = MCMTD(matrix, k, ei, strg); // matrix[k] * matrix[ei]

			int whole = matrix[si] * matrix[k] * matrix[ei]; // matrix[si] * matrix[ei]

			int totalOperations = part1 + part2 + whole;
			minOperations = Math.min(minOperations, totalOperations);
		}
		strg[si][ei] = minOperations;
		return minOperations;
	}

//	O((n^2)/2 * n) ~ O(n*3) time  | O(n^2) space
	private static int MCMBU(int[] matrix) {
		int n = matrix.length;
		int[][] strg = new int[n][n];
		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide - 1; ++si) {
				int ei = si + slide;

				if (si + 1 == ei)
					continue;

				int minOperations = Integer.MAX_VALUE;

				// k : splits
				for (int k = si + 1; k <= ei - 1; k++) {
					int part1 = strg[si][k]; // matrix[si] * matrix[k]
					int part2 = strg[k][ei]; // matrix[k] * matrix[ei]

					int whole = matrix[si] * matrix[k] * matrix[ei]; // matrix[si] * matrix[ei]

					int totalOperations = part1 + part2 + whole;

					minOperations = Math.min(minOperations, totalOperations);
				}
				strg[si][ei] = minOperations;

			}
		}
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<n; j++)
//				System.out.print(strg[i][j] + "\t ");
//			System.out.println();
//		}
		return strg[0][n - 1];
	}

}
