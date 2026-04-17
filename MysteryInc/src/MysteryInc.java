/** Ryley's Mystery Inc. Snack Search
 * Student Name: Ryley Carlson
 * CSC372 Module 5 Initial Discussion Post
 * Date: 2026-04-16
 * Program: MysteryInc.java
 * Description: A recursive solution to find Scooby Snacks in a stack of boxes.
 */

public class MysteryInc {

    public static void main(String[] args) {
        int boxes = 4;
        searchForSnacks(boxes);
    }

    /**
     * Recursive method to find snacks in a stack of boxes
     */
    public static void searchForSnacks(int boxCount) {
        // The Base Case: We found the bottom of the stack!
        if (boxCount == 0) {
            System.out.println("Ruh-roh! No more boxes. But wait... there's the snack! Mmm, delicious Scooby Snacks! Ruhehehee! We found them!");
        }
        // The Recursive Step: Open a box and move to the next one
        else {
            System.out.println("Opening box number " + boxCount + "... Sigh... it's just a dusty old map.");
            // We subtract 1 to move closer to the base case (0)
            searchForSnacks(boxCount - 1);
        }
    }
}