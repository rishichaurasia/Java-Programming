package Strings;

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));

	}
	
	static int start;
    static int end;
    static int len;
    
    public static String longestPalindrome(String s) {
        
        if(s.length() <= 1)
            return s;
        
        start = 0;
        end = 0;
        len = 0;
        
        for(int i = 1; i<s.length(); i++){
            getLongestPal(s, i, i-1);
            getLongestPal(s, i, i);
        }
        
        return s.substring(start, end);
        
    }
    
    public static void getLongestPal(String str, int i, int j){
        
        while(i>=0 && j<str.length()){
            if(str.charAt(i) != str.charAt(j))
                break;
            i--;
            j++;
        }
        
        int L = j-i-1;
        
        if(L > len){
            start = i+1;
            end = j;
            len = L;
        }
        
    }

}
