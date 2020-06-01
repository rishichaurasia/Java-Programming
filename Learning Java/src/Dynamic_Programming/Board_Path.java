package Dynamic_Programming;

public class Board_Path {

	public static void main(String[] args) {
		int N = 100000;
//		System.out.println(BPRec(0, N));
//		System.out.println(BPTopDown(0, N, new int[N]));
		System.out.println(BPBottomUp(0, N));
		System.out.println(BPBUSpaceEff(0, N));

	}
	
	/*
	 * Time Complexity
	 * T(n) = T(n-1) + T(n-2) + ... T(n-6) + 1
	 * T(n) = 6*T(n-1) +  1
	 * T(n) = O(6^n)
	 * 
	 * Shortcut: T(n) = No. of function frames * WD in one FF
	 * 				  = (6^0 + 6^1 + ... 6^(n-1)) * 1
	 * 				  = O(6^n)
	 */
	public static int BPRec(int curr, int end) {
		if(curr == end)
			return 1;
		if(curr > end)
			return 0;
		int count = 0;
		for(int i = 1; i<=6; i++) {
			count += BPRec(curr+i, end);
		}
		return count;
	}
	
	// Memoisation
	// TC: O(n)	SC: O(n) + Rec. extra space
	public static int BPTopDown(int curr, int end, int[] strg) {
		if(curr == end)
			return 1;
		if(curr > end)
			return 0;
		if(strg[curr] != 0)
			return strg[curr];
		int count = 0;
		for(int i = 1; i<=6; i++) {
			count += BPTopDown(curr+i, end, strg);
		}
		strg[curr] = count;
		return count;
	}
	
	
	// TC: O(n)	SC: O(n)
	public static int BPBottomUp(int curr, int end) {
		int[] strg = new int[end + 6];
		strg[end] = 1;
		for(int i = end-1; i>=0; i--) {
			strg[i] = strg[i+1] + strg[i+2] + strg[i+3] + strg[i+4] + strg[i+5] + strg[i+6];
		}
		return strg[0];
	}

	// TC: O(n)	SC: O(1)
		public static int BPBUSpaceEff(int curr, int end) {
			int[] strg = new int[6];
			strg[0] = 1;
			for(int i = end-1; i>=0; i--) {
				int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
				
				strg[5] = strg[4];
				strg[4] = strg[3];
				strg[3] = strg[2];
				strg[2] = strg[1];
				strg[1] = strg[0];
				strg[0] = sum;
			}
			return strg[0];
		}
	
}
