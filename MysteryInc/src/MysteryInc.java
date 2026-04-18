/**
 * Ryley's Mystery Inc. Product Search - The Spooky Calculation
 * Student Name: Ryley Carlson
 * CSC372 Module 5 Discussion
 * Date: 2026-04-18
 * Program: MysteryInc.java
 * Description: Using the power of recursion to multiply snacks before the ghost catches us!
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class MysteryInc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- The Mystery of the Zero-Sum Snack ---");

        try {
            // Shaggy: "Like, let's start digging through these 5 boxes, Scoob!"
            double finalProduct = calculateProduct(5, sc);
            System.out.println("\nCase Closed! The total product is: " + finalProduct);
        } catch (Exception e) {
            // Velma: "My glasses! I can't see a thing without my glasses... or my code!"
            System.out.println("Ruh-roh! A monster interfered with the calculation.");
        } finally {
            sc.close();
        }
    }

    /**
     * Recursive method: Each call is like opening another creepy door in a hallway.
     */
    public static double calculateProduct(int count, Scanner sc) {
        // 1. THE BASE CASE:
        // We've searched all the boxes and found the snacks!
        // We return 1.0 (the multiplicative identity) so we don't mess up the flavor.
        if (count == 0) {
            System.out.println("\n[All boxes checked! No monsters here! High five, Scooby!]");
            return 1.0;
        }

        try {
            System.out.print("Enter snack value for box #" + count + ": ");
            double currentNum = sc.nextDouble();

            // 2. THE EARLY EXIT (Short-Circuit):
            // Fred: "Hold on gang! If there's a zero in this box, the whole case is a wash!"
            if (currentNum == 0) {
                System.out.println("Zoinks! A zero?! Like, that's an empty box, Scoob! If we multiply by zero, the whole snack hoard disappears! Let's get out of here!");
                return 0.0;
            }

            // 3. THE RECURSIVE STEP:
            // Scooby: "Re-he-he! One snack down, moving to the next box!"
            // We multiply the current snack by whatever is found in the boxes below.
            return currentNum * calculateProduct(count - 1, sc);

        } catch (InputMismatchException e) {
            // Daphne: "Jeepers! That's not a number, that's a red herring!"
            System.out.println("That's not a number! Try again, Shaggy.");
            sc.next(); // Clear the ghost from the buffer
            return calculateProduct(count, sc); // "Let's try that box one more time!"
        }
    }
}