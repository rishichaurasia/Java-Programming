package July_Long_Challenge;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Chef_and_Dragon_Dens {

	static Scanner scn = new Scanner(System.in);
	
	static int[] tastiness;
	static int[] dens;
	static int[] GFL;
	static int[] GFR;
	static int[] sumL;
	static int[] sumR;
	
	public static void main(String[] args) {
		
		int n = scn.nextInt();
		int q = scn.nextInt();
		dens = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dens[i] = scn.nextInt();
		}
		GFL = NGR();
		GFR = NGL();
		
//		IntStream.of(GFL).forEach(x -> System.out.print(x + " "));
//		System.out.println();
//		IntStream.of(GFR).forEach(x -> System.out.print(x + " "));
//		System.out.println();
		tastiness = new int[n+1];
		for (int i = 1; i <=n; i++) {
			tastiness[i] = scn.nextInt();
		}
		presum();
		while(q-- > 0) {
			solve();
		}
	}
	
	public static int[] NGR() {
		int[] left = new int[dens.length];
		LinkedList<Integer> s1 = new LinkedList<>();
//		LinkedList<Integer> s2 = new LinkedList<>();
		for (int i = 1; i < dens.length; i++) {
			while (!s1.isEmpty() && dens[s1.peek()] < dens[i]) {
				left[s1.pop()] = i;
			}
			s1.push(i);
		}
		while (!s1.isEmpty()) {
			left[s1.pop()] = -1;
		}
		return left;
	}
	
	public static int[] NGL() {
		int[] right = new int[dens.length];
		LinkedList<Integer> s1 = new LinkedList<>();
//		LinkedList<Integer> s2 = new LinkedList<>();
		for (int i = dens.length-1; i >= 1; i--) {
			while (!s1.isEmpty() && dens[s1.peek()] < dens[i]) {
				right[s1.pop()] = i;
			}
			s1.push(i);
		}
		while (!s1.isEmpty()) {
			right[s1.pop()] = -1;
		}
		return right;
	}
	
	public static void presum() {
		sumL = new int[dens.length];
//		System.out.println(sumL.length);
		for(int i = sumL.length-1; i>0; --i) {
			if(GFL[i] == -1) {
				sumL[i] = tastiness[i];
			}else
				sumL[i]  = sumL[GFL[i]] + tastiness[i];
		}
//		IntStream.of(sumL).forEach(x -> System.out.print(x + " "));
//		System.out.println();
		sumR = new int[dens.length];
		for(int i = 1; i<sumR.length; ++i) {
			if(GFR[i] == -1) {
				sumR[i] = tastiness[i];
			}else
				sumR[i]  = sumR[GFR[i]] + tastiness[i];
		}
//		IntStream.of(sumR).forEach(x -> System.out.print(x + " "));
	}

	private static void solve() {
		int qtype = scn.nextInt();
		int input1 = scn.nextInt();
		int input2 = scn.nextInt();
		
		if(qtype == 1) {
			tastiness[input1] = input2;
			return;
		}
		
		// if qtype = 2
		
		if(input1 == input2) {
			System.out.println(tastiness[input1]);
			return;
		}
		
		long ans = 0;
		
		if(dens[input1] <= dens[input2]) {
			ans = -1;
		}else {
			int curr = GFR[input2];
			if(input1 < input2) {
				
				if(GFL[input1] > input1 && GFL[input1] < input2)
					ans = -1;
				else if(GFR[input1] == -1)
					ans = sumR[input2];
				else
					ans = sumR[input2] - sumR[GFR[input1]];
				
			}else {
				
				if(GFR[input1] < input1 && GFR[input1] > input2)
					ans = -1;
				else if(GFL[input1] == -1)
					ans = sumL[input2];
				else
					ans = sumL[input2] - sumL[GFL[input1]];

			}
		}
		System.out.println(ans);
		
//		long ans = tastiness[input2];
//		
//		if(dens[input1] <= dens[input2]) {
//			ans = -1;
//		}else {
//			if(input1 < input2) {
//				int prev = input2;
//				int curr = input2-1;
//				while(curr != input1) {
//					if(dens[curr] >= dens[input1]) {
//						ans = -1;
//						break;
//					}
//					if(dens[curr] > dens[prev]) {
//						ans+=tastiness[curr];
//						prev = curr;
//					}
//					--curr;
//				}
//			}else {
//				int prev = input2;
//				int curr = input2+1;
//				while(curr != input1) {
//					if(dens[curr] >= dens[input1]) {
//						ans = -1;
//						break;
//					}
//					if(dens[curr] > dens[prev]) {
//						ans+=tastiness[curr];
//						prev = curr;
//					}
//					++curr;
//				}
//				
//			}
//			if(ans != -1)
//				ans+=tastiness[input1];
//		}
//		System.out.println(ans);	
//		
	}

}
