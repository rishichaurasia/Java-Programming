package Array;

// https://leetcode.com/problems/longest-mountain-in-array/

public class Longest_Mountain_in_Array {
	public int longestMountain(int[] A) {
        int longestPeak = 0;
		
		int i = 1;
		while(i < A.length-1) {
			boolean isPeak = A[i-1] < A[i] && A[i]>A[i+1];
			if(!isPeak){
                i++;
				continue;
            }
			int lidx = i-1;
			while(lidx>=1 && A[lidx-1] < A[lidx])
				lidx--;
			int ridx = i+1;
			while(ridx<A.length-1 && A[ridx] > A[ridx+1])
				ridx++;
			int currPeak = ridx-lidx+1;
			if(currPeak>longestPeak)
				longestPeak = currPeak;
            i = ridx;
		}
			
		return longestPeak;
    }
	
	public int longestMountain1(int[] A) {
        int longestPeak = 0;
		
		int i = 1;
		while(i < A.length-1) {
			boolean isPeak = A[i-1] < A[i] && A[i]>A[i+1];
			if(!isPeak){
                i++;
				continue;
            }
			int lidx = i-1;
			while(lidx>=1 && A[lidx-1] < A[lidx])
				lidx--;
			int ridx = i+1;
			while(ridx<A.length-1 && A[ridx] > A[ridx+1])
				ridx++;
			int currPeak = ridx-lidx+1;
			if(currPeak>longestPeak)
				longestPeak = currPeak;
            i = ridx;
		}
			
		return longestPeak;
    }
}
