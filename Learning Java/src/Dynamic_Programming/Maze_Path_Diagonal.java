package Dynamic_Programming;

import java.util.Arrays;

public class Maze_Path_Diagonal {

	public static void main(String[] args) {
		int er = 20;
		int ec = 20;
//		System.out.println(MPDRecur(0, 0, er, ec));
		System.out.println(mazePathDTD(0, 0, er, ec, new int[er+1][ec+1]));
		System.out.println(mazePathDBU(er, ec));
		System.out.println(mazePathBUSE(er, ec));

	}
	
	// TC: 3^(er+ec) 
	public static int MPDRecur(int cr, int cc, int er, int ec) {
		if(cr == er && cc == ec)
			return 1;
		if(cr > er || cc > ec)
			return 0;
		int ch = MPDRecur(cr, cc+1, er, ec);
		int cv = MPDRecur(cr+1, cc, er, ec);
		int cd = MPDRecur(cr+1, cc+1, er, ec);
		return ch+cv+cd;
	}
	
	// TC: O(er*ec)	SC: O(er*ec) + rec. extra space
		public static int mazePathDTD(int cr, int cc, int er, int ec, int[][] strg) {
			if(cr == er && cc == ec)
				return 1;
			if(cr > er || cc > ec)
				return 0;
			if(strg[cr][cc] != 0)
				return strg[cr][cc];
			int ch = mazePathDTD(cr, cc+1, er, ec, strg);
			int cv = mazePathDTD(cr+1, cc, er, ec, strg);
			int cd = mazePathDTD(cr+1, cc+1, er, ec, strg);
			strg[cr][cc] = ch+cv+cd;
			return ch+cv+cd;
		}
		
		// TC: O(er*ec)	SC: O(er*ec)
		public static int mazePathDBU(int er, int ec) {
			int[][] strg = new int[er+2][ec+2];
			for(int row = er; row>=0; row--) {
				strg[row][ec] = 1;
				for(int col = ec-1; col>=0; col--) {
					strg[row][col] = strg[row+1][col] + strg[row][col+1] + strg[row+1][col+1];
				}
			}
			return strg[0][0];
		}
		
		// TC: O(er*ec)	SC: O(ec)
		public static int mazePathBUSE(int er, int ec) {
			int[] strg = new int[ec+1];
			Arrays.fill(strg, 1);
			for(int row = er-1; row>= 0; row--) {
				int diag = strg[ec];
				for(int col = ec-1; col>=0; col--) {
					int temp = strg[col];
					strg[col] += strg[col+1] + diag;
					diag = temp;
				}
			}
			return strg[0];
		}
	
}
