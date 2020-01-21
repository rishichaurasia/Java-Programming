package Lec7;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "code";
		printSubstrings(str);
	}

	public static void printSubstrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			String temp = "";
			for (int j = i; j < str.length(); j++) {
				temp += str.charAt(j);
				System.out.println(temp);
			}
		}
	}

}
