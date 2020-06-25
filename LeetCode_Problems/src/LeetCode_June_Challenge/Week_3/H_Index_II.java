package LeetCode_June_Challenge.Week_3;

public class H_Index_II {
	public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0 || citations[0] >= n)
            return n;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(citations[mid] >= n-mid)
                end = mid-1;
            else
                start = mid+1;
        }
        return n-start;
    }
}
