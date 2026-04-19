import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ryley's Mystery Inc. Product Search - The Spooky Calculation (Deluxe Edition)
 * Student Name: Ryley Carlson
 * Description: An enhanced recursive multiplier with dynamic scaling and logic safety.
 */
public class MysteryInc {

    // Static counter to track how deep in the mansion we are
    private static int totalBoxes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("--- THE MYSTERY OF THE ZERO-SUM SNACK ---");
        System.out.println("===========================================");

        try {
            // Velma: "Let's determine the scale of this investigation first."
            System.out.print("How many boxes are we checking, Shaggy? ");
            totalBoxes = getValidInt(sc);

            System.out.println("\nShaggy: \"Like, let's start digging through these " + totalBoxes + " boxes, Scoob!\"");

            double finalProduct = calculateProduct(totalBoxes, sc);

            // Final Verdict
            if (finalProduct == 0) {
                System.out.println("\n[Outcome: The snack hoard was a ghost! Total is 0.]");
            } else {
                System.out.printf("\nCase Closed! The total snack-power is: %.2f\n", finalProduct);
                System.out.println("Scooby-Doo: \"Rooby-Rooby-Doo!\"");
            }

        } catch (Exception e) {
            System.out.println("\n[Critical Error: The Phantom Virus has corrupted the system!]");
        } finally {
            sc.close();
            System.out.println("Mystery Machine powering down...");
        }
    }

    /**
     * Recursive method: Each call represents a deeper room in the haunted mansion.
     */
    public static double calculateProduct(int count, Scanner sc) {
        // 1. BASE CASE: The end of the hallway
        if (count <= 0) {
            System.out.println("\n[All boxes checked! No monsters here! High five, Scooby!]");
            return 1.0;
        }

        try {
            int currentBoxNumber = (totalBoxes - count) + 1;
            System.out.print("Box #" + currentBoxNumber + " - Enter snack value: ");
            double currentNum = sc.nextDouble();

            // 2. SHORT-CIRCUIT: The "Zero" Trap
            if (currentNum == 0) {
                System.out.println("Zoinks! A zero?! Like, the whole hoard is gone! Let's cheese it!");
                return 0.0;
            }

            // 3. RECURSIVE STEP: Moving to the next room
            // We multiply the current value by the result of the "next" room
            double result = calculateProduct(count - 1, sc);

            // If a previous room returned 0, keep passing that 0 back up the chain
            if (result == 0) return 0;

            return currentNum * result;

        } catch (InputMismatchException e) {
            System.out.println("Jeepers! That's a red herring! (Not a valid number)");
            sc.next(); // Clear the "ghost" from the buffer
            return calculateProduct(count, sc); // Re-try this specific room
        }
    }

    /**
     * Helper method to ensure Shaggy actually enters a number for the box count.
     */
    private static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Velma: \"Focus, Shaggy! I need a whole number!\"");
            sc.next();
        }
        return sc.nextInt();
    }
}

