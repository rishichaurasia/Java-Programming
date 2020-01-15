package Lec3;

import java.util.Scanner;

public class Temp_conv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int min_t = scn.nextInt();
		int max_t = scn.nextInt();
		int step = scn.nextInt();
		while (min_t <= max_t) {
			int c = (int) ((5.0 / 9) * (min_t - 32));
			System.out.println(min_t + "\t" + c);
			min_t += step;
		}
	}

}
