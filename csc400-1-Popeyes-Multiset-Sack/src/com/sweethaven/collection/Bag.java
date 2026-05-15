package com.sweethaven.collection;

import java.util.ArrayList;

/**
 * Requirement 1: Design a Java class called `Bag` that implements the bag data structure.
 * Requirement 4: Comment your code appropriately to explain the functionality of each method.
 *
 * Theme Context: This structure simulates Popeye's duffle bag (multiset),
 * allowing duplicate elements like extra spinach rations or iron anchors.
 */
public class Bag<T> {
    // Internal array list to hold Popeye's cargo elements
    private final ArrayList<T> elementsHold = new ArrayList<>();

    /**
     * Requirement 2a: Adds an item of type T to the bag.
     * Duplicates are perfectly fine here. Blow me down!
     */
    public void add(T item) {
        elementsHold.add(item);
    }

    /**
     * Requirement 2b: Removes one occurrence of the item from the bag, if it exists.
     * Throws a single instance overboard and leaves other matching items intact.
     */
    public void remove(T item) {
        elementsHold.remove(item);
    }

    /**
     * Requirement 2c: Returns true if the item exists in the bag; otherwise false.
     * Scans the ocean horizon to verify if the cargo is on board.
     */
    public boolean contains(T item) {
        return elementsHold.contains(item);
    }

    /**
     * Requirement 2d: Returns the number of occurrences of the specified item in the bag.
     * Returns 0 if the item does not exist.
     */
    public int count(T item) {
        int continuousTally = 0;
        for (T checkedEntry : elementsHold) {
            // Built-in equals check handles standard strings and custom objects gracefully
            if (checkedEntry != null && checkedEntry.equals(item)) {
                continuousTally++;
            }
        }
        return continuousTally;
    }

    /**
     * Prints out a clean visual log representation of the current deck contents.
     */
    @Override
    public String toString() {
        return elementsHold.toString();
    }
}
