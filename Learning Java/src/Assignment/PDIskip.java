package Assignment;

public class PDIskip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
Print the following output:
5
3
1
2
4
 */
		pdiSkip(5);
	}
	
	public static void pdiSkip(int n) {
		if(n==0)
			return;
		if(n%2==1)
			System.out.println(n);
		pdiSkip(n-1);
		if(n%2==0)
			System.out.println(n);
	}

}
