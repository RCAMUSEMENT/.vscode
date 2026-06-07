public class RyleysMissingNumberDetector {

    /**
     * Student Name: Ryley Carlson
     * Course: CSC400 Module 3 Critical Thinking Assignment
     * Date: 2026-05-31
     * Program: RyleysMissingNumberDetector.java
     * This method identifies the single missing integer from a sequential range of unique integers.
     * The input is an unsorted array containing n unique integers from the range 1 to (n + 1),
     * where exactly one integer is missing. The method will efficiently compute the missing number
     * uses a bitwise XOR approach to avoid integer overflow issues.
     *
     * @param arr The unsorted input array containing unique elements.
     * @return The integer that is missing from the sequential range.
     */
    public static int findMissingNumber(int[] arr) {
        // Defensive check: handle edge cases where the array is empty or is missing.
        // If no data exists, logically assume the first number (1) is missing.
        if (arr == null || arr.length == 0) {
            return 1;
        }

        // Tracks down the array length (n), which represents the number of elements present.
        int n = arr.length;

        // This variable is what keeps a running result of my bitwise operations.
        // Initialize it to 0 because any number X XORed with 0 remains X (identity property).
        int xorTracker = 0;

        // Step #1: Loop through and XOR all integers that SHOULD exist within the perfect range.
        // The numbers in a complete range span sequentially from 1 up to and including (n + 1).
        // This loop runs exactly (n + 1) times, contributing O(n) to time complexity.
        for (int i = 1; i <= n + 1; i++) {
            // Applying bitwise XOR compound assignment. This is what accumulates the bits of the range.
            xorTracker ^= i;
        }

        // Step #2: Loop through and XOR all the actual values present inside the array.
        // This loop checks each and every element within the array and runs it exactly n times, contributing to O(n).
        for (int num : arr) {
            // All numbers present in the array will hit this tracker for a second time.
            // This is because X ^ X = 0, duplicates cancel each other out completely.
            xorTracker ^= num;
        }

        // Step #3: Return the final result.
        // Since every pairing has canceled itself out to zero, the only remaining value
        // inside 'xorTracker' is the single missing number that never had a matching pair.
        return xorTracker;
    }

    /**
     * Main method acting as the test harness to run the programs logic.
     */
    public static void main(String[] args) {
        // Sample input array provided by the problem prompt: length n = 5
        // Contains 5 unique integers picked randomly from the range 1 through 6.
        // The integer '2' is intentionally missing.
        int[] sampleArray = {3, 6, 5, 1, 4};

        // Execute the function and capture the calculated missing value
        int missingNumber = findMissingNumber(sampleArray);

        // Output the result to the console to confirm accuracy
        System.out.println("The missing integer is: " + missingNumber);
        // Expected Terminal Output: 2
    }
}