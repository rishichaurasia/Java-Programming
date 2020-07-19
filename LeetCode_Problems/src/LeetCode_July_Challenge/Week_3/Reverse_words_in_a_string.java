package LeetCode_July_Challenge.Week_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Reverse_words_in_a_string {

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
	
	public static String reverseWords(String s) {
		String words[] = s.split(" "); 
        StringBuilder ans = new StringBuilder(); 
        for (int i = words.length - 1; i >= 0; i--) { 
            if(!words[i].isEmpty()) {
            	if(ans.length() > 0)
            		ans.append(" ");
            	ans.append(words[i]);
            }
        } 
		
		return ans.toString();
		
    }

}
