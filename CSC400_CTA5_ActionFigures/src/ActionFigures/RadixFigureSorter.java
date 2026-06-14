package ActionFigures;

public class RadixFigureSorter {
    /**
     * Sorts our action figures by their SKU strings using an LSD Radix Sort.
     */
    public static void sort(ActionFigure[] inventory) {
        if (inventory == null || inventory.length == 0) {
            return;
        }

        // Figure out the maximum string length to know how many passes to run
        int maxLen = 0;
        for (ActionFigure figure : inventory) {
            if (figure.getSkuCode().length() > maxLen) {
                maxLen = figure.getSkuCode().length();
            }
        }

        // Loop from the rightmost character down to the leftmost (LSD method)
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            stableCountingSort(inventory, pos);
        }
    }

    /**
     * Core counting sort pass that keeps identical elements in their original relative order.
     */
    private static void stableCountingSort(ActionFigure[] inventory, int pos) {
        int n = inventory.length;
        ActionFigure[] output = new ActionFigure[n];
        int[] count = new int[257]; // Extended ASCII range (256) plus room for offsets

        // Step 1: Count how often each character shows up
        for (int i = 0; i < n; i++) {
            int charVal = getCharCode(inventory[i].getSkuCode(), pos);
            count[charVal + 1]++;
        }

        // Step 2: Transform counts into actual array positions
        for (int i = 0; i < 256; i++) {
            count[i + 1] += count[i];
        }

        // Step 3: Populate the output array backwards to maintain a stable sort
        for (int i = n - 1; i >= 0; i--) {
            int charVal = getCharCode(inventory[i].getSkuCode(), pos);
            output[count[charVal]++] = inventory[i];
        }

        // Step 4: Write the sorted batch back into our main storage array
        System.arraycopy(output, 0, inventory, 0, n);
    }

    /**
     * Grabs a character value safely. If a short SKU drops off, it returns 
     * a space character code (32) to group shorter items at the front.
     */
    private static int getCharCode(String s, int pos) {
        if (pos >= s.length()) {
            return 32; 
        }
        return s.charAt(pos);
    }
}
// EOF