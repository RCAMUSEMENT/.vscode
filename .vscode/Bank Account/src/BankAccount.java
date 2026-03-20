/**
 * Student Name: Ryley Carlson
 * CSC372 Module 1 Critical Thinking Assignment
 * Date: 2026-03-20
 * Program: BankAccount.java
 * Description: This program defines a BankAccount class that serves as a base for different types of bank accounts.
 * It includes attributes for the account holder's first name, last name, account ID,
 * and balance, along with methods for depositing and withdrawing funds, as well as getters and setters for the attributes.
 */
/**
 * Part 1: BankAccount Superclass
 * The BankAccount class is designed to represent a generic bank account with common attributes and behaviors.
 * This class serves as the base class for different types of bank accounts.
 * It includes attributes for the account holder's first name, last name, account ID, and balance.
 * The class provides methods for depositing and withdrawing funds, as well as getters and setters for the attributes.
 * The constructor initializes the balance to zero, ensuring that all accounts start with a consistent state.
 */

public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    // Constructor: This constructor ensures that every BankAccount starts with a balance of zero, simply by initializing the balance attribute to 0.0.
    //  providing a consistent initial state for all accounts.
    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Error: The Deposit amount can only be positive. If you would like to withdraw, please select the withdrawal option from the menu.");
        }
    }

    public void withdrawal(double amount) {
        if (amount > 0) {
            this.balance -= amount;
        }
    }

    // Getters and Setters for the attributes to allow for encapsulation and controlled access to the account information.
    // These methods enable other classes to set and retrieve the account holder's
    //  first name, last name, account ID, and balance while maintaining the integrity of the data.
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }
    public void setAccountID(int accountID) { this.accountID = accountID; }
    public int getAccountID() { return accountID; }
    public double getBalance() { return balance; }

    public void accountSummary() {
        System.out.println("--- YourAccount Summary ---");
        System.out.println("ID: " + accountID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}

