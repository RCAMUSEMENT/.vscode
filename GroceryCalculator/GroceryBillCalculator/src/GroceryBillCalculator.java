import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class GroceryBillCalculator {

    public static void main(String[] args) {
        NumberFormat currencyFormat;
        double couponAmount;
        double billWeek1, billWeek2, billWeek3, billWeek4;
        double totalMonthly;
        double avgWeekly;
        double totalMonthlyCoupon;
        double avgWeeklyCoupon;
        // Create a NumberFormat instance for currency formatting in US locale
        try ( // Create a Scanner object for user input
                Scanner scanner = new Scanner(System.in)) {
            // Create a NumberFormat instance for currency formatting in US locale
            currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            // Define the variables
            // Prompt the user for the coupons total amount as a decimal
            System.out.print("Enter the coupon amount as a decimal (example, .10): ");
            couponAmount = scanner.nextDouble();
            // Ensure the value is set to 10% (.10) if the value exceeds 100% or is less than or equal to zero
            if (couponAmount <= 0 || couponAmount > 1.0) {
                couponAmount = 0.10;
            }   // Prompt the user for weeks 1-4 grocery bills total amounts
            System.out.print("Enter Week 1 grocery bill: ");
            billWeek1 = scanner.nextDouble();
            System.out.print("Enter Week 2 grocery bill: ");
            billWeek2 = scanner.nextDouble();
            System.out.print("Enter Week 3 grocery bill: ");
            billWeek3 = scanner.nextDouble();
            System.out.print("Enter Week 4 grocery bill: ");
            billWeek4 = scanner.nextDouble();
            // Close the scanner
        }

        // Calculate the monthly and weekly average for groceries
        totalMonthly = billWeek1 + billWeek2 + billWeek3 + billWeek4;
        avgWeekly = totalMonthly / 4.0;
        totalMonthlyCoupon = totalMonthly * (1 - couponAmount);
        avgWeeklyCoupon = totalMonthlyCoupon / 4.0;

        // Display monthly total and weekly average without the coupon
        System.out.println("\n--- Results Without Coupon ---");
        System.out.println("Monthly Total: " + currencyFormat.format(totalMonthly));
        System.out.println("Weekly Average: " + currencyFormat.format(avgWeekly));

        // Display monthly total and weekly average with the coupon
        System.out.println("\n--- Results With Coupon ---");
        System.out.println("Monthly Total: " + currencyFormat.format(totalMonthlyCoupon));
        System.out.println("Weekly Average: " + currencyFormat.format(avgWeeklyCoupon));
    }
}


