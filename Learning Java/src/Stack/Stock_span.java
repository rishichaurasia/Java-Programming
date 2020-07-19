package Stack;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Stock_span {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int[] prices = new int[n];
		
		for (int i = 0; i < prices.length; i++) {
			prices[i] = scn.nextInt();
		}
		
		stockSpan(prices);

	}
	
	public static void stockSpan(int[] prices) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int[] result = new int[prices.length];		
		for(int i = 0; i<prices.length; ++i) {
			if(stack.isEmpty() || prices[stack.peek()] > prices[i]) {
				stack.push(i);
				result[i] = 1;
				continue;
			}
			
			while(!stack.isEmpty() && prices[stack.peek()] <= prices[i])
				stack.pop();
			
			if(stack.isEmpty())
				result[i] = i+1;
			else
				result[i] = i - stack.peek();
			
			stack.push(i);
		}
		
		IntStream.of(result).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

}
