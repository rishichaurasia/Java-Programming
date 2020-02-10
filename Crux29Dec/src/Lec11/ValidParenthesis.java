package Lec11;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validParenthesis2(3, 0, 0, "");
	}

	public static void validParenthesis2(int n, int open, int close, String ans) {
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open < n)
			validParenthesis2(n, open + 1, close, ans + "(");
		if (close < open)
			validParenthesis2(n, open, close + 1, ans + ")");
	}

	public static void validParenthesis(int n, int open, int close, String ans) {
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || open < close) {
			return;
		}
		validParenthesis(n, open + 1, close, ans + "(");
		validParenthesis(n, open, close + 1, ans + ")");
	}

}
