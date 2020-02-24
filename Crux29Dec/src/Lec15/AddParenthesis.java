package Lec15;

import java.util.ArrayList;

public class AddParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(differentWaysToAddParenthesis("2*3-4*5"));
		

	}
	
	public static ArrayList<String> differentWaysToAddParenthesis(String ques) {
		ArrayList<String> mr = new ArrayList<>();
		if (ques.indexOf('+') == -1 && ques.indexOf('-') == -1 && ques.indexOf('*') == -1) {
			mr.add(ques);
			return mr;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				String p1 = ques.substring(0, i);
				String p2 = ques.substring(i + 1);
				ArrayList<String> rr1 = differentWaysToAddParenthesis(p1);
				ArrayList<String> rr2 = differentWaysToAddParenthesis(p2);
				for (String val1 : rr1) {
					for (String val2 : rr2) {
						mr.add("("+val1 + ch + val2+")");
					}
				}
			}
		}
		
		return mr;
	}


}
