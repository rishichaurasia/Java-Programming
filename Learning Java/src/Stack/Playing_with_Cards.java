package Stack;

/*
 * You are at a casino. There are N stacked cards on pile . Each card has a number written on it. Then there will be Q iterations. In ith iteration, you start picking up the cards in Ai-1th pile from the top one by one and check whether the number written on the card is divisible by the ith prime number. If the number is divisible, you stack that card on pile Bi. Otherwise, you stack that card on pile Ai. After Q iterations, cards can only be on pile B1, B2, B3, . . . BQ, AQ . Output numbers on these cards from top to bottom of each piles in order of B1, B2, B3, . . . BQ, AQ .

Input Format
First line contains N and Q. The next line contains N space separated integers representing the initial pile of cards i.e., A0. The leftmost value represents the bottom plate of the pile.

Constraints
N < 10^5

Output Format
Output N lines, each line containing the number written on the card.

Sample Input
5 1
3 4 7 6 5
Sample Output
4
6
3
7
5
Explanation
Initially:

A0 = [3, 4, 7, 6, 5]<-TOP

After 1st iteration:

A0 = []<-TOP

A1 = [5, 7, 3]<-TOP

B1 = [6, 4]<-TOP

Now first print B1 from top to bottom then A1 from top to bottom.
 */

import java.util.Scanner;
import java.util.Stack;

public class Playing_with_Cards {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		int[] primes = getFirstQPrimes(new int[q]);
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= n; i++)
			stack.push(scn.nextInt());
		play(stack, primes, q);

	}

	private static void play(Stack<Integer> stack, int[] primes, int q) {

		for (int i = 0; i < q; i++) {
			Stack<Integer> bi = new Stack<>();
			Stack<Integer> ai = new Stack<>();
			while (!stack.isEmpty()) {
				int n = stack.pop();
				if (n % primes[i] == 0)
					bi.push(n);
				else
					ai.push(n);
			}
			while (!bi.isEmpty())
				System.out.println(bi.pop());
			stack = ai;
		}
		while (!stack.isEmpty())
			System.out.println(stack.pop());

	}

	private static int[] getFirstQPrimes(int[] primes) {
		primes[0] = 2;
		int num = 3;
		for (int i = 1; i < primes.length; i++) {
			while (true) {
				if (isPrime(num)) {
					primes[i] = num;
					break;
				}
				num += 2;
			}
			num += 2;
		}
		return primes;
	}

	private static boolean isPrime(int num) {
		if (num == 2)
			return true;
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

//	static final int MAX = 1299709; // 10^5 th prime number
//    static boolean[] sieve = new boolean[MAX];
//    static ArrayList<Integer> primes = new ArrayList<>();
//
//    static void createSieve() {
//        for (int i = 0; i < MAX; i++) {
//            sieve[i] = true;
//        }
//        sieve[0] = sieve[1] = false;
//        for (int i = 2; i < MAX; i++) {
//            if (sieve[i]) {
//                primes.add(i);
//                for (int j = i * i; j < MAX && j >= 0; j += i) {
//                    sieve[j] = false;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        createSieve();
//
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//
//        Stack<Integer> s = new Stack<>();
//
//        while (n-- > 0) {
//            int d = sc.nextInt();
//            s.push(d);
//        }
//        Stack<Integer> a = new Stack<>();
//        Stack<Integer> b = new Stack<>();
//
//        Queue<Integer> qu = new LinkedList<>();
//
//        for (int i = 1; i <= q; i++) {
//            while (!s.empty()) {
//                int x = s.peek();
//                int y = primes.get(i - 1);
//                if (x % y == 0) {
//                    b.push(x);
//                } else {
//                    a.push(x);
//                }
//                s.pop();
//            }
//            while (!b.empty()) {
//                int x = b.peek();
//                qu.add(x);
//                b.pop();
//            }
//            s = a;
//            a = new Stack<>();
//        }
//        while (!qu.isEmpty()) {
//            System.out.println(qu.poll());
//        }
//        while (!s.empty()) {
//            System.out.println(s.peek());
//            s.pop();
//        }
//    }

}
