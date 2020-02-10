package Lec11;

public class printCoinToss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printCointoss(3, "");
//		printCointoss_noConsequtiveHead(3, "");
		printCointoss_noConsequtiveHead2(3, "", false);

	}

	public static void printCointoss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		printCointoss(n - 1, ans + "H");
		printCointoss(n - 1, ans + "T");
	}

	public static void printCointoss_noConsequtiveHead(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		if (ans == "" || ans.charAt(ans.length() - 1) == 'T')
			printCointoss_noConsequtiveHead(n - 1, ans + "H");
		printCointoss_noConsequtiveHead(n - 1, ans + "T");
	}

	public static void printCointoss_noConsequtiveHead2(int n, String ans, boolean flag) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		if (flag == false)
			printCointoss_noConsequtiveHead2(n - 1, ans + "H", true);
		printCointoss_noConsequtiveHead2(n - 1, ans + "T", false);
	}

}
