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