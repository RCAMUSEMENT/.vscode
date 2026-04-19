/**
 * RYLEY'S MYSTERY INC. STRATEGIC TRAP OPERATIONS
 * Student Name: Ryley Carlson
 * CSC372 Module 5 Critical Thinking Assignment
 * Date: 2026-04-05
 * Program: MysteryInc.java
 * Description: This recursive application simulates a high-stakes snack retrieval mission for Mystery Inc.
 * It implements deep recursion to calculate the product of exactly five snack values needed to set a trap.
 * The program features dynamic logic for ghost encounters (35% probability), short-circuit safety for
 * zero-value inputs, and an immersive narrative unmasking sequence involving Cosgood Creeps and Cuthbert Crawls.
 * This application emphasizes mathematical recursion and thematic storytelling to fulfill module requirements.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class MysteryInc {
    private static int totalBoxes;
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;

        do {
            // --- THE MYSTERY MACHINE ENTERS ---
            System.out.println("          _________________________");
            System.out.println("         / _      _      _      _  \\");
            System.out.println("        | [ ]    [ ]    [ ]    [ ]  |");
            System.out.println("    ____|___________________________|____");
            System.out.println("   |    |  _      MYSTERY      _    |    |");
            System.out.println("   |    | (_)     MACHINE     (_)   |    |");
            System.out.println("   |____|___________________________|____|");
            System.out.println("     \\___/                         \\___/");

            System.out.println("\n===========================================");
            System.out.println("--- MISSION: THE GHOST-CATCHER CRUNCH ---");
            System.out.println("===========================================");

            try {
                totalBoxes = 5;
                System.out.println("Fred: \"Alright gang, we need to gather enough Scooby Snacks for Shaggy and Scooby to lure in the ghost!\"");
                System.out.println("Daphne: \"How does exactly " + totalBoxes + " boxes of Scooby Snacks sound, Shaggy!\"");
                System.out.println("\nShaggy: \"Like, I say let's start digging through these " + totalBoxes + " boxes, Scoob!\"");
                System.out.println("Scooby-Doo: \"Rah-rah!\"");
                System.out.println("Velma: \"Okay well, we need to find them all before the ghost finds us to set the trap!\"");

                // Start the recursion
                double finalProduct = calculateProduct(totalBoxes, sc);

                // Final Verdict
                if (finalProduct == 0) {
                    System.out.println("\n[Failure: The ghost has found the snacks first. Scooby and Shaggy are still hungry! The trap has failed!]");
                    System.out.println("Daphne: \"Oh no! The ghosts have ruined our plan!\"");
                    System.out.println("Shaggy: \"Like, let's let's get out of here!!\"");
                } else {
                    System.out.printf("\nSuccess! With %.2f Scooby Snack-power, the trap was set perfectly!\n", finalProduct);
                    System.out.println("Fred: \"Let's head back to the Mystery Machine!\"");
                    unmasking();
                    System.out.println("Scooby-Doo: \"Scooby Dooby Doo!\"");
                }
            } catch (Exception e) {
                System.out.println("\n[Critical Error: The Phantom Virus has corrupted the system!]");
            }

            // Start Again Prompt
            System.out.print("\nVelma: \"Should we start again and look for another mystery?\" (yes/no): ");
            playAgain = sc.next();
            System.out.println("\n");

        } while (playAgain.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Mystery Machine powering down...");
    }

    /**
     * Recursive method: Finding boxes and avoiding the ghost.
     */
    public static double calculateProduct(int count, Scanner sc) {
        // BASE CASE: All 5 boxes checked
        if (count <= 0) {
            System.out.println("\n[All boxes checked! No monsters here! High five, Scooby!]");
            return 1.0;
        }

        try {
            int currentBoxNumber = (totalBoxes - count) + 1;

            // 35% Ghost Encounter Chance
            if (rand.nextInt(100) < 35) {
                System.out.println("\n     .-. ");
                System.out.println("    (o o)  JEEPERS! A green phantom appeared before you could get the snacks!");
                System.out.println("    | O | ");
                System.out.println("    `~~~' ");
                return 0.0;
            }

            System.out.print("Box #" + currentBoxNumber + " - Enter snack value: ");
            double currentNum = sc.nextDouble();

            // Short-circuit if a 0 is entered
            if (currentNum == 0) {
                System.out.println("Zoinks! A zero?! Like, the whole hoard is gone! Let's cheese it!");
                return 0.0;
            }

            // RECURSIVE STEP
            double result = calculateProduct(count - 1, sc);

            // Pass the 0 back up if the ghost was found in a deeper level
            if (result == 0) return 0;
            return currentNum * result;

        } catch (InputMismatchException e) {
            System.out.println("Daphne: \"Jeepers! That's a red herring! (Not a valid number)\"");
            sc.next(); // Clear buffer
            return calculateProduct(count, sc); // Retry this specific box
        }
    }

    /**
     * The Big Reveal of the Lawyer Duo!
     */
    private static void unmasking() {
        System.out.println("\nFred: \"Now, let's see who these phantoms really are...\"");
        System.out.println("[*Fred pulls off the masks*]");
        System.out.println("Velma: \"Just as I suspected! The lawyers!\"");
        System.out.println("Everyone: \"COSGOOD CREEPS AND CUTHBERT CRAWLS?!\"");
        System.out.println("Creeps: \"We would have gotten away with the fortune, too...\"");
        System.out.println("Crawls: \"...if it weren't for you meddling kids and that stupid dog!\"");
    }
}