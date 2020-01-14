package Assignment;

import java.util.Scanner;

public class Assignment029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Write a program that works as a simple calculator.
//
//		1.It reads a character (ch)
//		2.If ch is among '+', '-', '*', '/' or '%' it furthur takes two numbers 
//		  (N1 and N2 as input). It then performs appropriate appropriate operation
//		  between numbers and print the number.
//		3.If ch is 'X' or 'x', the program terminates.
//		4.If ch is any other character, the program should print 'Invalid operation. 
//		  Try again.' and seek inputs again (starting from character).
//
//
//		Write code to achieve above functionality.
//
//		Input Format
//		Constraints
//		0 <= Input integers <= 100000000
//		( It is assured that the second integer provided for division and modulo operations will not be 0. )
//
//		Output Format
//		Output a single integer output for the operations in a new line each.
//
//		Sample Input
//		* 
//		1 
//		2 
//		/ 
//		4 
//		2 
//		+ 
//		3 
//		2 
//		; 
//		X
//		Sample Output
//		2 
//		2 
//		5 
//		Invalid operation. Try again.
//		Explanation
//		Maybe use a do-while.
		
		Scanner scn = new Scanner(System.in);
		char ch = scn.next().charAt(0);
		char[] arr = {'+', '-', '/', '*' , '%' };
		while(true) {
			int flag = 0;
			for(int i = 0; i<5; i++) {
				if(ch == arr[i]) {
					flag = 1;
					int a = scn.nextInt();
					int b = scn.nextInt();
					int result;
					if(i == 0)
						result = a+b;
					else if(i == 1)
						result = a-b;
					else if(i == 2)
						result = a/b;
					else if(i == 3)
						result = a*b;
					else
						result = a%b;
					System.out.println(result);
				}
			}
			if(flag == 0) {
				if( ch == 'X' || ch == 'x')
					break;
				else
					System.out.println("Invalid operation. Try again.");
			}
			ch = scn.next().charAt(0);
			
		}
		
	}

}
