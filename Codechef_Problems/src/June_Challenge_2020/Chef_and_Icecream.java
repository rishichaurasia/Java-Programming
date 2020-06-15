package June_Challenge_2020;

import java.util.Scanner;

public class Chef_and_Icecream {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
		    int[] queue = new int[scn.nextInt()];
		    for (int i = 0; i < queue.length; i++) {
				queue[i] = scn.nextInt();
			}
		    if(ifPossible(queue))
		    	System.out.println("YES");
		    else
		    	System.out.println("NO");
		}
	}
	
	public static boolean ifPossible(int[] queue) {
		if(queue[0] != 5)
			return false;
		int[] coins = {1, 0};
		for(int i = 1; i<queue.length; i++) {
			int coin = queue[i];
			if(coin == 5)
				coins[0]++;
			else if(coin == 10 && coins[0] > 0) {
				coins[0]--; coins[1]++;
			}else if(coin == 15) {
				if(coins[1] > 0) {
					coins[1]--;
				}else if(coins[0] > 1)
					coins[0] -= 2;
				else
					return false;
			}else
				return false;
		}
		return true;
	}

}
