import java.util.Scanner;

/**
 * Ryley's Scooby-Snack-Sized Product Search
 * Student Name: Ryley Carlson
 * Description: A recursive solution to find the product of five numbers, Scooby-style!
 */
public class MysteryInc {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Scooby and Shaggy are hungry! Enter 5 numbers to find the total snack power:");

            // Start the recursion with 5 boxes/numbers
            double finalSnackPower = findSnackPower(input, 5);

            System.out.println("\nZoinks! The final snack power is: " + finalSnackPower);
            System.out.println("Ruhehehee! That's a lot of Scooby Snacks!");
        }
    }

    /**
     * Recursive method to gather numbers and multiply them
     */
    public static double findSnackPower(Scanner input, int boxesLeft) {
        // The Base Case: We've opened all 5 boxes!
        // We return 1 because multiplying by 1 won't change the previous results.
        if (boxesLeft == 0) {
            System.out.println("\n[Ruh-roh! No more boxes left to open!]");
            return 1;
        }

        // The Recursive Step: Open a box, get a number, and keep searching
        else {
            System.out.print("Opening box " + boxesLeft + "... Enter a number for this snack: ");
            double snackValue = input.nextDouble();

            System.out.println("  'Like, wow, Scoob! This box has a value of " + snackValue + "!'");

            // We multiply the current snackValue by the result of the next recursive call
            return snackValue * findSnackPower(input, boxesLeft - 1);
        }
    }
}