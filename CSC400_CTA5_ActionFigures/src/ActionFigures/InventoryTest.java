package ActionFigures;

public class InventoryTest {
    public static void main(String[] args) {
        // Mapping our real action figure names directly to the assignment's data strings
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

        System.out.println("=========================================================");
        System.out.println("     ACTION FIGURE WAREHOUSE LOGISTICS: RADIX SORT       ");
        System.out.println("=========================================================");
        System.out.println("Unsorted Backroom Inventory:");
        printInventory(backroomStock);
        System.out.println("---------------------------------------------------------");

        // Run the sort engine
        RadixFigureSorter.sort(backroomStock);

        System.out.println("Sorted Catalog Registry (Alphabetical via SKU Code):");
        printInventory(backroomStock);
        System.out.println("=========================================================");
    }

    private static void printInventory(ActionFigure[] inventory) {
        for (ActionFigure figure : inventory) {
            System.out.println(" " + figure.toString());
        }
    }
}