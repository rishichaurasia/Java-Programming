package Assignment;

import java.util.Scanner;

/*
Take as input N. N is the number of rows and columns on a square board. Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east). But the diagonal step is allowed only when the player is currently on one of the diagonals (there are two diagonals)

a. Write a recursive function which returns the count of different ways the player can travel across the board. Print the value returned.

b. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).

Input Format
Enter the number N.

Constraints
None

Output Format
Display the total number of paths and display all the possible paths in a space separated manner.

Sample Input
3
Sample Output
VVHH VHVH VHHV VHD HVVH HVHV HVD HHVV DVH DHV DD 
11
 */

public class MazePathDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printMazePath1(1, 1, n, "");
		System.out.println();
		System.out.print(countMazePath1(1, 1, n, ""));

	}

	public static void printMazePath1(int sr, int sc, int n, String ans) {
		if (sr == n && sc == n) {
			System.out.print(ans + " ");
			return;
		}
		if (sc > n || sr > n)
			return;
		printMazePath1(sr + 1, sc, n, ans + "V");
		printMazePath1(sr, sc + 1, n, ans + "H");
		if (sr == sc || sr + sc == n + 1)
			printMazePath1(sr + 1, sc + 1, n, ans + "D");
	}

	public static int countMazePath1(int sr, int sc, int n, String ans) {
		if (sr == n && sc == n) {
			return 1;
		}
		if (sc > n || sr > n)
			return 0;
		int vc = countMazePath1(sr + 1, sc, n, ans + "V");
		int hc = countMazePath1(sr, sc + 1, n, ans + "H");
		int dc = 0;
		if (sr == sc || sr + sc == n + 1)
			dc = countMazePath1(sr + 1, sc + 1, n, ans + "D");
		return vc + hc + dc;
	}

}
