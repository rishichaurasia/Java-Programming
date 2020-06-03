package Dynamic_Programming;

public class Maze_Path {

	public static void main(String[] args) {
		int er = 100;
		int ec = 100;
//		System.out.println(mazePathRecur(0, 0, er, ec));
		System.out.println(mazePathTD(0, 0, er, ec, new int[er+1][ec+1]));
		System.out.println(mazePathBU(er, ec));
		System.out.println(mazePathBUSE(er, ec));
	}
	
	// TC: 2^(er+ec)            // TC = (No. of calls)^ht
	public static int mazePathRecur(int cr, int cc, int er, int ec) {
		if(cr == er && cc == ec)
			return 1;
		if(cr > er || cc > ec)
			return 0;
		int ch = mazePathRecur(cr, cc+1, er, ec);
		int cv = mazePathRecur(cr+1, cc, er, ec);
		return ch+cv;
	}
	
	// TC: O(er*ec)	SC: O(er*ec) + rec. extra space
	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if(cr == er && cc == ec)
			return 1;
		if(cr > er || cc > ec)
			return 0;
		if(strg[cr][cc] != 0)
			return strg[cr][cc];
		int ch = mazePathTD(cr, cc+1, er, ec, strg);
		int cv = mazePathTD(cr+1, cc, er, ec, strg);
		strg[cr][cc] = ch+cv;
		return ch+cv;
	}
	
	// TC: O(er*ec)	SC: O(er*ec)
	public static int mazePathBU(int er, int ec) {
		int[][] strg = new int[er+2][ec+2];
		for(int row = er; row>=0; row--) {
			strg[row][ec] = 1;
			for(int col = ec-1; col>=0; col--) {
				strg[row][col] = strg[row+1][col] + strg[row][col+1];
			}
		}
		return strg[0][0];
	}
	
	// TC: O(er*ec)	SC: O(ec)
	public static int mazePathBUSE(int er, int ec) {
		int[] strg = new int[ec+1];
		strg[ec] = 1;
		for(int row = er; row>= 0; row--) {
			for(int col = ec-1; col>=0; col--) {
				strg[col] += strg[col+1];
			}
		}
		return strg[0];
	}

}
