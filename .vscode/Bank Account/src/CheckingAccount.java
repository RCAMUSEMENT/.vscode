public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.0;

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    // Overrides the withdrawal method to include overdraft fee logic
    public void processWithdrawal(double amount) {
        super.withdrawal(amount);
        // If withdrawal results in a negative balance, apply the following fee
        if (this.balance < 0) {
            this.balance -= OVERDRAFT_FEE;
            System.out.println("ALERT: Overdraft detected. A $" + OVERDRAFT_FEE + " fee has been applied to your account.");
            System.out.printf("Your Current Negative Balance: $%.2f%n", getBalance());
        }
    }

    // Displays all attributes of the CheckingAccount, including those inherited from BankAccount and the specific interest rate for this account type.
    public void displayAccount() {
        // Displays all superclass attributes via accountSummary
        super.accountSummary();
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
        System.out.println("-----------------------");
    }
    
    // Calculates and applies interest to the account balance based on the current balance and the specified interest rate.
    // This method allows the account to grow larger over time by adding the calculated interest to the existing balance of the account.
    public void processInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.printf("Total Interest of $%.2f applied.%n", interest);
    }
}

