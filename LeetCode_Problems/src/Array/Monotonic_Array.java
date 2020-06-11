package Array;

// https://leetcode.com/problems/monotonic-array/

public class Monotonic_Array {
	
	//O(n) time | O(1) space
	public boolean sol1(int[] A) {
        int n = A.length;
        if(n < 3) return true;
        if(A[0] < A[n-1]){
            for(int i=1; i<A.length; i++){
                if(A[i-1] > A[i]) return false;
            }
            return true;
        }
        if(A[0] > A[n-1]){
            for(int i=1; i<A.length; i++){
                if(A[i-1] < A[i]) return false;
            }
            return true;
        }
        for(int i=1; i<A.length; i++){
            if(A[i-1] != A[i]) return false;
        }
        return true;
    }
	
	//O(n) time | O(1) space
	public boolean sol2(int[] A) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        
        for(int i = 1; i<A.length; i++) {
        	if(A[i] < A[i-1])
        		isNonDecreasing = false;
        	else if(A[i] > A[i-1])
        		isNonIncreasing = false;
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
