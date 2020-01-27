package Lec8;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringBuilder sb = new StringBuilder(s);
		OddEven(sb);
		System.out.println(sb);

	}

	public static void OddEven(StringBuilder sb) {
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (i % 2 == 0)
				sb.setCharAt(i, --c);
			else
				sb.setCharAt(i, ++c);
		}
	}

}
