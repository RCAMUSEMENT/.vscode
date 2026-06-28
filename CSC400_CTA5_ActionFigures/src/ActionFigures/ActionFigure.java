/**
 * Ryley's Action Figure Warehouse Logistics: Radix Sort
 * Student Name: Ryley Carlson
 * Course: CSC400 Module 5 Critical Thinking Assignment
 * Date: 2026-06-14
 * Program: ActionFigure.java
 * Description: This class defines the ActionFigure data structure, which includes a SKU code for sorting and a figure name for display.
 * It serves as the basic unit of inventory in our warehouse logistics system, allowing us to manage
 * and sort our action figure stock effectively using the Radix Sort algorithm implemented in RadixFigureSorter.java.
 * The ActionFigure class is designed to be immutable, ensuring that once an instance is created, its state cannot be altered.
 * This immutability is crucial for maintaining data integrity during sorting operations and prevents accidental modifications to
 * the inventory data.
 */

package ActionFigures;

/**
 * Represents an action figure with a SKU code for sorting and a name for display.
 * This class is immutable and serves as the basic data structure for our inventory management and sorting operations.
 */
public class ActionFigure {
    private final String skuCode; // Unique identifier for sorting and inventory management
    private final String figureName; // Descriptive name for the action figure, used for display purposes

    public ActionFigure(String skuCode, String figureName) {
        this.skuCode = skuCode; // Initialize the SKU code for this action figure
        this.figureName = figureName; // Initialize the figure name for this action figure
    }

    public String getSkuCode() {
        return skuCode; // Getter for the SKU code, used by the sorting algorithm to access the key for sorting
    }

    @Override
    public String toString() {
        return String.format("[%s: %s]", skuCode, figureName); // Format the string to show both SKU and figure name for better readability in outputs 
    }
}