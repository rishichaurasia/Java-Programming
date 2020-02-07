package Assignment;

import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
You are given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

Input Format
First line contains integer t as number of test cases. Next t lines contains two lines. For each test case, 1st line contains two integers n and m which represents the number of books and students and 2nd line contains n space separated integers which represents the number of pages of n books in ascending order.

Constraints
1 < t < 50
1< n < 100
1< m <= 50
1 <= Ai <= 1000

Output Format
Print the maximum number of pages that can be assigned to students.

Sample Input
1
4 2
12 34 67 90
Sample Output
113 
Explanation
1st students : 12 , 34, 67 (total = 113)
2nd students : 90 (total = 90)
Print max(113, 90)
 */

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			int nob = scn.nextInt();
			int nos = scn.nextInt();
			int[] books = new int[nob];
			for (int i = 0; i < books.length; i++) {
				books[i] = scn.nextInt();
			}
			minimizeMaxPages(books, nos);
		}
	}
	
	public static void minimizeMaxPages(int[] books, int nos) {
		int low = books[books.length-1];
		int high = 0;
		for(int val: books)
			high+=val;
		int answer = low;
		while(low<=high) {
			int mid = (low+high)/2;
			if(isValidConfig(books, mid, nos)) {
				answer = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(answer);
	}
	public static boolean isValidConfig(int[] books, int mid, int nos) {
		int stu_count = 1;
		int sum = 0;
		for(int i = 0; i<books.length; i++) {
			sum+=books[i];
			if(sum>mid) {
				sum = books[i];
				stu_count++;
			}
			if(stu_count>nos)
				return false;
		}
		return true;
	}

}
