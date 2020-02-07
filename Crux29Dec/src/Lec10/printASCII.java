package Lec10;

public class printASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printASCII("ab","");

	}
	public static void printASCII(String ques, String ans) {
		if(ques.length()==0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		printASCII(roq, ans);
		printASCII(roq, ans+ch);
		printASCII(roq, ans+(int)ch);
	}

}
