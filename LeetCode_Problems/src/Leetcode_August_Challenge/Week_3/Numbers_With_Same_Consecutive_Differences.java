package Leetcode_August_Challenge.Week_3;

import java.util.ArrayList;
import java.util.List;

public class Numbers_With_Same_Consecutive_Differences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        if(N == 1)
            list.add(0);
        for(int i = 1; i<10; i++){
            numsSameConsecDiff(N-1, K, i, list);
        }
        int[] result = new int[list.size()];
        int i = 0;
        for(int num: list)
        	result[i++] = num;
        return result;
    }
    
    public static void numsSameConsecDiff(int N, int K, int num, List<Integer> list){
    	if(N == 0){
            list.add(num);
            return;
        }
        int lastDigit = num%10;
        
        if(lastDigit-K >= 0)
            numsSameConsecDiff(N-1, K, num*10+(lastDigit-K), list);
        
        if(lastDigit+K <= 9 && K!= 0)
            numsSameConsecDiff(N-1, K, num*10+(lastDigit+K), list);
        
    }

}
