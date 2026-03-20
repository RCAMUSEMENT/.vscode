import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            CheckingAccount myAccount = new CheckingAccount();
            
            System.out.println("=== Bank Account Setup ===");
            System.out.print("Please enter your First Name: ");
            myAccount.setFirstName(scnr.nextLine());
            
            System.out.print("Please enter your Last Name: ");
            myAccount.setLastName(scnr.nextLine());
            
            // Verifier for Account ID (Numeric check)
            System.out.print("Please enter your Account ID: ");
            while (!scnr.hasNextInt()) {
                System.out.print("Sorry, this is an Invalid ID. Please only enter numeric values (e.g. 8675309): ");
                scnr.next();
            }
            myAccount.setAccountID(scnr.nextInt());
            
            // Verifier for Interest Rate (Numeric check)
            System.out.print("Please enter your Annual Interest Rate: ");
            while (!scnr.hasNextDouble()) {
                System.out.print("Sorry, this is an Invalid Rate. Please enter a decimal (e.g. 2.5): ");
                scnr.next();
            }
            myAccount.setInterestRate(scnr.nextDouble());
            
            boolean sessionActive = true;
            while (sessionActive) {
                System.out.println("\n--- Options ---");
                System.out.println("1. Deposit  2. Withdrawal  3. Apply Interest  4. Summary  5. Exit");
                System.out.print("Selection: ");
                
                // Verifier for menu selection (Numeric check)
                while (!scnr.hasNextInt()) {
                    System.out.print("Please only input numbers 1-5: ");
                    scnr.next();
                }
                int choice = scnr.nextInt();
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("How much would you like to deposit today? ");
                        if (scnr.hasNextDouble()) myAccount.deposit(scnr.nextDouble());
                    }
                    case 2 -> {
                        System.out.print("How much would you like to withdraw today? ");
                        if (scnr.hasNextDouble()) myAccount.processWithdrawal(scnr.nextDouble());
                    }
                    case 3 -> myAccount.processInterest();
                    case 4 -> myAccount.displayAccount();
                    case 5 -> sessionActive = false;
                    default -> {
                    }
                }
                
                if (sessionActive) {
                    System.out.print("\nDo you want to perform another action? (yes/no): ");
                    String response = scnr.next().toLowerCase();
                    if (response.startsWith("n")) sessionActive = false;
                }
            }
            System.out.println("Thank you for using Ryley's banking service! Here's your final account summary:");
            myAccount.displayAccount();
        }
    }
}
