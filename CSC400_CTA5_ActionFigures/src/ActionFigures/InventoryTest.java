/** * Action Figures Inventory Management and Sorting System
* Student Name: Ryley Carlson
* Course: CSC400 Module 5 Critical Thinking Assignment
* Date: 2026-06-14
* Program: InventoryTest.java
* Description: A test class to demonstrate the functionality of the RadixFigureSorter and the ActionFigure data structure.
* It creates a sample inventory of action figures with various SKU codes, prints the unsorted inventory, sorts it using the RadixFigureSorter,
* and then prints the sorted inventory to verify that the sorting algorithm works correctly.
* This class serves as a practical demonstration of how the sorting algorithm interacts with our ActionFigures data model,
* making sure that our inventory management system is both functional and efficient.
*/

package ActionFigures; // Package declaration for organizing related classes

public class InventoryTest {
    public static void main(String[] args) {
        // Mapping out my real action figure stock with a variety of SKU codes to test the sorting algorithm
        ActionFigure[] backroomStock = {
            new ActionFigure("joke", "The Joker Deluxe Edition"),
            new ActionFigure("book", "Bookworm Batman (Retro Variant)"),
            new ActionFigure("back", "Bane (Backbreaker Battle-Damaged)"),
            new ActionFigure("dig", "Diggle Green Arrow Sidekick"),
            new ActionFigure("desk", "Desk-Duty Agent Coulson"),
            new ActionFigure("word", "Word Bearer Chaos Space Marine"),
            new ActionFigure("fish", "Fisherman Aquaman Target Exclusive"),
            new ActionFigure("ward", "Warden John Forge (Halo Series)"),
            new ActionFigure("dish", "Dishonored Corvo Attano Figure"),
            new ActionFigure("wit", "Witcher Geralt of Rivia (Ronin)"),
            new ActionFigure("deed", "Deedlit Record of Lodoss War Mini"),
            new ActionFigure("fast", "Fast & Furious Dominic Toretto"),
            new ActionFigure("dog", "Dog-Welder Section 8 Comedy Figure"),
            new ActionFigure("bend", "Bender (Metallic Retro Robot)")
        };

        // A set of action figures I have collected over the years with varying SKU lengths and characters to thoroughly test the radix sort implementation
        System.out.println("========================================================="); // Decorative header for clarity in output
        System.out.println(" RYLEY'S ACTION FIGURE WAREHOUSE LOGISTICS: RADIX SORT "); // Title for the test output
        System.out.println("========================================================="); // Decorative footer for clarity in output
        System.out.println("Unsorted Backroom Inventory:"); // Initial state of the inventory before sorting
        printInventory(backroomStock); // Display the unsorted inventory to the console
        System.out.println("---------------------------------------------------------"); // Separator for better readability in the console output

        // Run the sort engine
        RadixFigureSorter.sort(backroomStock); // Sort the inventory using our custom radix sort implementation

        System.out.println("Sorted Catalog Registry (Alphabetical via SKU Code):"); // State of the inventory after sorting, showing the final sorted order to the console
        printInventory(backroomStock); // Display the sorted inventory to the console
        System.out.println("========================================================="); // Decorative footer to signify the end of the test output
    }

    private static void printInventory(ActionFigure[] inventory) {
        for (ActionFigure figure : inventory) {
            System.out.println(" " + figure.toString()); // Print each figure's details in a formatted manner for better readability
        }
    }
}