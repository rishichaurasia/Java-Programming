package DUCS_Assignment;

import java.util.Scanner;

class NoMatchException extends Exception {
    public NoMatchException(String message){
        super(message);
    }
}

public class StringMatching {
	
	public static void matchString(String str) throws NoMatchException {
		if (str.equals("India")) {
            System.out.print("String Matched!\n");
        } else {
            throw new NoMatchException("String does not Match!\n");
        }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		try {
			matchString(str);
		}catch(NoMatchException e) {
			System.out.println(e);
		}

	}

}
