package DUCS_Assignment;

import java.util.Scanner;

public class AccountsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sav_acct A1 = new Sav_acct();
		A1.newAcct();
		A1.deposit(10000);
		A1.withdraw(5000);
		A1.computeInterest();
		A1.details();
		
		Curr_acct A2 = new Curr_acct();
		A2.newAcct();
		A2.deposit(15);
		A2.withdraw(14);
		A2.checkMinimumBal();
		A2.details();
	}

}

class Accounts {
	float tot_bal = 0;
	String Cust_Name;
	long Acc_no;
	String Acc_type;
	
	public void newAcct(String Acc_type) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Name : ");
		Cust_Name = scn.nextLine();
		this.Acc_type = Acc_type;
		Acc_no = (int)(Math.random()*10000);
		details();
	}
	
	public void deposit(int amount) {
		tot_bal+=amount;
		System.out.println("Amount of Rs" + amount + " deposited in your account.");
		displayBal();
	}
	
	public void displayBal() {
		System.out.println("Total Balance = " + tot_bal);
		System.out.println("-------------------------------------");
	}
	
	public void withdraw(int amount) {
		if(amount<=tot_bal) {
			tot_bal-=amount;
			System.out.println("Amount of Rs" + amount + " is debited from your account.");
		}else {
			System.out.println("Insufficient Balance!");
		}
		displayBal();
	}
	
	public void checkbook() {
		if(Acc_type == "Savings")
			System.out.println("Checkbook facility not Available!");
		else {
			System.out.println("Checkbook facility Available!");
		}
	}
	
	public void details() {
		System.out.println("Account Number : " + Acc_no);
		System.out.println("Name : " + Cust_Name);
		System.out.println("Account Type : " + Acc_type);
		System.out.println("Total Balance : Rs " + tot_bal);
		checkbook();
		System.out.println("-------------------------------------");
	}
	
}

class Curr_acct extends Accounts{
	
	private float penality_rate = 10.0f;
	private int min_bal = 3000;
	
	public void newAcct() {
		super.newAcct("Current");
	}
	
	public void checkMinimumBal() {
		if(tot_bal < min_bal) {
			float penality = imposePenality();
			System.out.println("Penality Imposed of Rs." + penality);
		}else {
			System.out.println("Minimum Balance is maintained!");
		}
		displayBal();
	}
	
	private float imposePenality() {
		float penality = (float)penality_rate/100* tot_bal;
		tot_bal *= ((100-penality_rate)/100);
		return penality;
	}
}

class Sav_acct extends Accounts{
	private float interest_rate = 3.5f;
	
	public void newAcct() {
		super.newAcct("Savings");
	}
	
	void computeInterest() {
		float interest = tot_bal*(interest_rate/4)/100;
		tot_bal += interest;
		System.out.println("Interest of Rs" + interest + " credited to your account.");
		displayBal();
	}
	
}
