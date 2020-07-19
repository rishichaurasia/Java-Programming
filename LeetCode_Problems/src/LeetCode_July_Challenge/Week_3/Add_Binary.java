package LeetCode_July_Challenge.Week_3;

public class Add_Binary {

	public static void main(String[] args) {
		String a = "11", b = "1";

		System.out.println(addBinary(a, b));

	}

	public static String addBinary(String a, String b) {

		StringBuilder sb = new StringBuilder();

		int idx1 = a.length() - 1;
		int idx2 = b.length() - 1;

		int n = Math.max(a.length(), b.length());

		int carry = 0;

		while (idx1>=0 || idx2>=0 || carry>0) {

			int c1 = idx1 >= 0 && a.charAt(idx1) == '1' ? 1 : 0;
			int c2 = idx2 >= 0 && b.charAt(idx2) == '1' ? 1 : 0;

			int sum = c1 + c2 + carry;

			sb.append(sum % 2);
			carry = sum/=2;

			--idx1;
			--idx2;

		}

		return sb.reverse().toString();

	}

}
