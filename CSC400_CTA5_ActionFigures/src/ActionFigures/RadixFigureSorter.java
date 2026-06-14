/**
 * Action Figures Inventory Management and Sorting System
 * Student Name: Ryley Carlson
 * Course: CSC400 Module 5 Critical Thinking Assignment
 * Date: 2026-06-14
 * Program: RadixFigureSorter.java
 * Description: This class implements the LSD Radix Sort algorithm to sort an array of ActionFigure objects based on their SKU codes.
 */

package ActionFigures; // Package declaration for organizing related classes

public class RadixFigureSorter {
    /**
     * Sorts action figures by their SKU strings using an LSD Radix Sort.
     */
    public static void sort(ActionFigure[] inventory) {
        if (inventory == null || inventory.length == 0) {
            return; // No sorting needed for null or empty arrays
        }

        // Figure out the maximum string length to know how many passes to run
        int maxLen = 0;
        for (ActionFigure figure : inventory) {
            if (figure.getSkuCode().length() > maxLen) {
                maxLen = figure.getSkuCode().length(); // Update maxLen if this figure's SKU is longer than the current max
            }
        }

        // Loop from the rightmost character down to the leftmost (LSD method)
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            stableCountingSort(inventory, pos); // Perform a stable counting sort for the current character position
        }
    }

    /**
     * Core counting sort pass that keeps identical elements in their original relative order.
     */
    private static void stableCountingSort(ActionFigure[] inventory, int pos) {
        int n = inventory.length;
        ActionFigure[] output = new ActionFigure[n]; // Output array to hold sorted figures for this pass
        int[] count = new int[257]; // Extended ASCII range (256) plus room for offsets

        // Step #1: Count how often each character shows up
        for (int i = 0; i < n; i++) {
            int charVal = getCharCode(inventory[i].getSkuCode(), pos); // Get the character code for the current position,
            // treating missing characters as space (32)
            count[charVal + 1]++; // Increment the count for this character (offset by 1 to handle 0-based indexing)
        }

        // Step #2: Transform counts into actual array positions
        for (int i = 0; i < 256; i++) {
            count[i + 1] += count[i]; // Cumulative count to determine positions in the output array
        }

        // Step #3: Populate the output array backwards to maintain a stable sort
        for (int i = n - 1; i >= 0; i--) {
            int charVal = getCharCode(inventory[i].getSkuCode(), pos); // Get the character code for the current position
            output[count[charVal]++] = inventory[i]; // Place the figure in the correct position and increment the count for that character
        }

        // Step #4: Write the sorted batch back into our main storage array
        System.arraycopy(output, 0, inventory, 0, n); // Copy the sorted output back to the original array
    }

    /**
     * Grabs a character value safely. If a short SKU drops off, it returns 
     * a space character code (32) to group shorter items at the front.
     */
    private static int getCharCode(String s, int pos) { // Return the ASCII code of the character at pos, or 32 if pos exceeds string length
        if (pos >= s.length()) {
            return 32; 
        }
        return s.charAt(pos); // Return the ASCII code of the character at the specified position
    }
}
// EOF