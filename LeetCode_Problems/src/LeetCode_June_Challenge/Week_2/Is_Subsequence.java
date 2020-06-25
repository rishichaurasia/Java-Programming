package LeetCode_June_Challenge.Week_2;

public class Is_Subsequence {

	public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
        int sidx = 0; int tidx = 0;
        while(tidx < t.length()){
            if(s.charAt(sidx) == t.charAt(tidx++)){
                if(++sidx == s.length())
                    return true;
            }
        }
        return false;
    }
	
}
