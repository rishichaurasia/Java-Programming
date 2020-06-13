package Arrays;

import java.util.Arrays;

public class Smallest_Difference {

	public static void main(String[] args) {
		int[] arr1 = {-1, 5, 10, 20, 28, 3}; // n
		int[] arr2 = {26, 134, 135, 15, 17}; // m
		long start = System.nanoTime();
		int[] res = sol3(arr1, arr2);
		long end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(res[0] + " " + res[1]);
	}
	
	// O(n*m) time | O(1) space 
	public static int[] sol1(int[] arr1, int[] arr2) {
		int minDiff = Integer.MAX_VALUE;
		int[] ans = null;
		for(int i: arr1) {
			for(int j: arr2) {
				int currDiff = Math.abs(i-j);
				if(currDiff < minDiff) {
					ans = new int[] {i,j};
					minDiff = currDiff;
				}
			}
		}
		return ans;
	}
	
	// O(nlogn + mlogm) time | O(1) space
	public static int[] sol2(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int minDiff = Integer.MAX_VALUE;
		int[] res = null;
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < arr1.length && idx2 < arr2.length ) {
			int diff = Math.abs(arr1[idx1] - arr2[idx2]);
			if(diff < minDiff) {
				res = new int[] {arr1[idx1], arr2[idx2]};
				minDiff = diff;
			}
			if(arr1[idx1] < arr2[idx2])
				idx1++;
			else
				idx2++;
		}
		return res;		
		
	}
	
	// O(nlogn + mlogm) time | O(1) space  || Optimal
	public static int[] sol3(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int minDiff = Integer.MAX_VALUE;
		int currDiff = 0;
		int[] res = null;
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < arr1.length && idx2 < arr2.length ) {
			int num1 = arr1[idx1];
			int num2 = arr2[idx2];
			if(num1<num2) {
				currDiff = num2-num1;
				idx1++;
			}else if(num2<num1) {
				currDiff = num1-num2;
				idx2++;
			}else
				return new int[] {num1, num2};
			
			if(currDiff < minDiff) {
				res = new int[] {arr1[idx1], arr2[idx2]};
				minDiff = currDiff;
			}
		}
		return res;		
		
	}

}
