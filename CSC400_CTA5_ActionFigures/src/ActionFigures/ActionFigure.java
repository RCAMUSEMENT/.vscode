package ActionFigures;

/**
 * Simple object model representing an action figure entry in our inventory.
 */
public class ActionFigure {
    private final String skuCode;
    private final String figureName;

    public ActionFigure(String skuCode, String figureName) {
        this.skuCode = skuCode;
        this.figureName = figureName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    @Override
    public String toString() {
        return String.format("[%s: %s]", skuCode, figureName);
    }
}