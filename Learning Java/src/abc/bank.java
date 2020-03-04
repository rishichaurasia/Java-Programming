package abc;

import java.io.*; //import the "BufferedReader" and "InputStreamReader" classes needed to get the user input.

class Account {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String name; // Name of account holder.
    String acc_no; // Account number.
    String acc_type; // Type of account.
    float balance; // Account number and balance.

    void init(String account_type) throws IOException {// "init_name()" function throws an "IOException" error which
                                                       // needs to be caught.
        init_name(); // Get account holders name.
        init_acc_no(); // Generate a 10-digit account number.
        acc_type = account_type;
        balance = 0.0f; // Initial balance.
        System.out.println("Thank you for creating a " + acc_type + "-account with XYZ Bank! 🙏");
        System.out.println("Your account number is: " + acc_no);
    }

    void init_name() throws IOException { // "BufferedReader.readLine()" function throws an "IOException" error which
                                          // needs to be caught.
        System.out.print("Enter your name: ");
        name = br.readLine().trim(); // Remove whitespace from both ends of the input.
    }

    void init_acc_no() {
        acc_no = "";
        for (int i = 0; i < 10; i++) {
            acc_no += (char) (Math.random() * 10 + 48); // Generate 10 random digits.
        }
    }

    void deposit(float amount) {
        balance += amount;
        System.out.println("Amount of ₹" + amount + " deposited successfully! ✅");
        System.out.println("Updated balance is: ₹" + balance);
    }

    void withdraw(float amount) {
        if (balance >= amount) { // Check whether a withdrawal can be made.
            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful! ✅");
            System.out.println("Updated balance is: ₹" + balance);
        } else {
            System.out.println("Insufficient balance! ❌");
        }
    }

    void display_balance() {
        System.out.println("Dear " + name + ", the balance of your " + acc_type + "-account is: ₹" + balance);
        System.out.println("Thank you for using our services! 🙏");
    }
}

class Sav_acct extends Account {
    final static float interest_rate = 6.0f; // Declare global constants.

    void init() throws IOException { // "super.init()" function throws an "IOException" error which needs to be
                                     // caught.
        super.init("savings"); // Call the "init()" function of the parent class with the parameter "savings"
                               // as the account-type.
    }

    void calc_interest() {
        float interest = balance * interest_rate / 100.0f; // Calculate the interest applicable on the current balance.
        balance += interest;
        System.out.println("Interest of ₹" + interest + " paid! ✅ Updated balance is: ₹" + balance);
    }
}

class Curr_acct extends Account {
    final static float minimum_balance = 10000.0f, penalty_rate = 4.0f;

    void init() throws IOException { // "super.init()" function throws an "IOException" error which needs to be
                                     // caught.
        super.init("current"); // Call the "init()" function of the parent class with the parameter "current"
                               // as the account-type.
    }

    void calc_penalty() {
        if (balance < minimum_balance) { // Check whether a penalty is applicable.
            float penalty = (minimum_balance - balance) * penalty_rate / 100.0f; // Calculate the penalty applicable on
                                                                                 // the current balance.
            balance -= penalty;
            System.out.println("Penalty of ₹" + penalty
                    + " imposed as minimum balance has not been maintained! ✅ Updated balance is: ₹" + balance);
        } else {
            System.out.println("Penalty not applicable as minimum balance has been maintained!");
        }
    }
}

public class bank {
    public static void main(String args[]) throws IOException { // "acc1.init()" and "acc2.init()" functions throw
                                                                // "IOException" errors which need to be caught.
        Sav_acct acc1 = new Sav_acct();
        Curr_acct acc2 = new Curr_acct();
        acc1.init();
        acc1.deposit(20000.0f);
        acc1.calc_interest();
        acc1.withdraw(5000.0f);
        // Output:
        // Enter your name: Person 1
        // Thank you for creating a savings-account with XYZ Bank! 🙏
        // Your account number is: 6707721739
        // Amount of ₹20000.0 deposited successfully! ✅
        // Updated balance is: ₹20000.0
        // Interest of ₹1200.0 paid! ✅ Updated balance is: ₹21200.0
        // Withdrawal of ₹5000.0 successful! ✅
        // Updated balance is: ₹16200.0
        acc2.init();
        acc2.deposit(18000);
        acc2.calc_penalty();
        acc2.withdraw(10000);
        acc2.calc_penalty();
        // Output:
        // Enter your name: Person 2
        // Thank you for creating a current-account with XYZ Bank! 🙏
        // Your account number is: 5549379600
        // Amount of ₹18000.0 deposited successfully! ✅
        // Updated balance is: ₹18000.0
        // Penalty not applicable as minimum balance has been maintained!
        // Withdrawal of ₹10000.0 successful! ✅
        // Updated balance is: ₹8000.0
        // Penalty of ₹80.0 imposed as minimum balance has not been maintained! ✅
        // Updated balance is: ₹7920.0
    }
}


