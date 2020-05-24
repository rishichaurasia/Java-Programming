package Backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/additive-number/

public class Additive_Number {

	public static void main(String[] args) {
//		String num = "199100199";
		String num = "112358";
		System.out.println(isAdditiveNumber(num));
	}
	
	static boolean flag;
	
	public static boolean isAdditiveNumber(String num) {
		flag = false;
        isAdditiveNumber(num, 0, new ArrayList<BigInteger>());
        return flag;
    }

	private static void isAdditiveNumber(String num, int idx, ArrayList<BigInteger> temp) {
		if(idx == num.length() && temp.size() > 2) {
			flag = true;
			return;
		}
		for (int i = idx; i < num.length() && !flag; i++) {
			String part = num.substring(idx, i + 1);
			if (hasLeadingZeroes(part))
				continue;
			BigInteger n = new BigInteger(part);
			if (isAdditiveSeq(temp, n)) {
				temp.add(n);
				isAdditiveNumber(num, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private static boolean hasLeadingZeroes(String s) {
		return s.length() > 1 && s.charAt(0) == '0';
	}

	private static boolean isAdditiveSeq(List<BigInteger> list, BigInteger n) {
		if (list.size() < 2)
			return true;
		BigInteger last = list.get(list.size() - 1);
		BigInteger scndLast = list.get(list.size() - 2);
		BigInteger sum = last.add(scndLast);
		return n.compareTo(sum) == 0;
	}

}
