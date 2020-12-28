package Array;

import java.util.Arrays;
import java.util.Comparator;

public class _179_Largest_Number {

	private static class NumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (b + a).compareTo(a + b);
		}
	}

	public String largestNumber(int[] nums) {
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNums[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strNums, new NumberComparator());
		;
		if (strNums[0].equals("0"))
			return "0";
		StringBuilder result = new StringBuilder();
		for (String num : strNums) {
			result.append(num);
		}
		return new String(result);
	}

}
