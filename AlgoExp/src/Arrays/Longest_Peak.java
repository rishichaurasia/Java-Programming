package Arrays;

public class Longest_Peak {
	
	// O(n) time | O(1) space
	public static int sol1(int[] arr) {
		int longestPeak = 0;
		
		int i = 1;
		while(i < arr.length-1) {
			boolean isPeak = arr[i-1] < arr[i] && arr[i]>arr[i+1];
			if(!isPeak) {
				i++;
				continue;
			}
			int lidx = i-1;
			while(lidx>=1 && arr[lidx-1] < arr[lidx])
				lidx--;
			int ridx = i+1;
			while(ridx<arr.length-1 && arr[ridx] > arr[ridx+1])
				ridx++;
			int currPeak = ridx-lidx+1;
			if(currPeak>longestPeak)
				longestPeak = currPeak;
			i = ridx;
		}
			
		return longestPeak;
	}

}
