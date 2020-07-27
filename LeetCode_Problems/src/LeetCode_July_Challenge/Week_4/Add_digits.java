package LeetCode_July_Challenge.Week_4;

public class Add_digits {

	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits1(num));
	}
	
	public static int addDigits(int num) {

		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		if (sum > 9)
			return addDigits(sum);
		else
			return sum;

	}
	
	// O(1) Time
	public static int addDigits1(int num) {
        if(num < 10)
            return num;
        int rem = num%9;
        return rem == 0 ? 9 : rem;
    }

}
