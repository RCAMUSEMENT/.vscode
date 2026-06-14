/** 
 * Popeye's Nautical Multiset Cargo Hold 
 * Student Name: Ryley Carlson 
 * Course: CSC400 Module 2 Critical Thinking Assignment 
 * Date: 2026-05-24 
 * Program: Bag.java 
 * Description: Core generic Bag data structure class implementing a multiset. 
 * Allows duplicate item tracking without enforcing an order, utilizing an internal 
 * ArrayList structure with added null-safe counting logic checkpoints. 
 * Extended to calculate cargo size, merge holds, and extract distinct cargo. 
 */
package com.sweethaven.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/** 
 * Requirement #1: I have designed a Java class called `Bag` that implements the bag data structure. 
 * Requirement #4: I have added comments to explain the functionality of each of the methods. 
 * Requirement #5 (Additional Requirements): I have implemented the `size()`, `merge(Bag<T> otherBag)`, 
 * and `distinct()` methods as specified in week's 2 Critical Thinking assignment. 
 * Theme Context: This structure simulates Popeye's duffle bag (multiset), 
 * where it allows duplicate elements like extra canned spinach or pipe tobacco. 
 * The `Bag` class provides methods to add, remove, check for containment, count occurrences, 
 * calculate total size, merge with another bag, and filter for distinct items. 
 */
public class Bag<T> implements Iterable<T> { 
    // Internal array list to hold Popeye's cargo elements 
    private final ArrayList<T> elementsHold = new ArrayList<>();

    /** 
     * Requirement #2.1: Adds an item of type T to the bag. 
     * Duplicates are perfectly fine here. Well, Blow me down! 
     */
    public void add(T item) {
        elementsHold.add(item);
    }

    /** 
     * Requirement #2.2: Removes one occurrence of the item from the bag, if it exists. 
     * Throws a single instance overboard and leaves other matching items intact. 
     */
    public void remove(T item) {
        elementsHold.remove(item);
    }

    /** 
     * Requirement #2.3: Returns true if the item exists in the bag; otherwise false. 
     * Scans the ocean horizon to verify if the cargo is on board. 
     */
    public boolean contains(T item) {
        return elementsHold.contains(item);
    }

    /** 
     * Requirement #2.4: Returns the number of occurrences of the specified item in the bag. 
     * Returns 0 if the item does not exist. 
     */
    public int count(T item) {
        int continuousTally = 0;
        for (T checkedEntry : elementsHold) {
            // Built-in equals check that handles all of the standard strings and custom objects gracefully 
            if (checkedEntry != null && checkedEntry.equals(item)) {
                continuousTally++;
            }
        }
        return continuousTally;
    }

    /** 
     * // ========================================================================= 
     * // NEW ADDITIONS FOR CRITICAL THINKING ASSIGNMENT WEEK 2: int size() Method 
     * // ========================================================================= 
     * Requirement #5.1: Implement the `size()` method to return the total number of elements in the bag, including duplicates. 
     * This method returns the total number of elements in the bag, including duplicates. 
     * Tally up every single piece of crate sitting on the deck. 
     * Returns 0 if the bag is empty. 
     */
    public int size() {
        return elementsHold.size();
    }

    /** 
     * // ========================================================================= 
     * // NEW ADDITIONS FOR CRITICAL THINKING ASSIGNMENT WEEK 2: void merge(Bag<T> otherBag) Method 
     * // ========================================================================= 
     * Requirement #5.2: Implement the `merge(Bag<T> otherBag)` method to merge the elements of another bag into the current bag. 
     * This method merges the elements of otherBag into the current bag. 
     * Combines Olive Oyl's cargo directly onto Popeye's main vessel deck. 
     * Requires a non-null otherBag to merge. If null is passed, the method does nothing. 
     */
    public void merge(Bag<T> otherBag) {
        if (otherBag != null) {
            for (T item : otherBag) {
                this.add(item);
            }
        }
    }

    /** 
     * // ========================================================================= 
     * // NEW ADDITIONS FOR CRITICAL THINKING ASSIGNMENT WEEK 2: Bag<T> distinct() Method 
     * // ========================================================================= 
     * Requirement #5.3: Implement the `distinct()` method to return a new bag that contains only the distinct elements from the current bag. 
     * This method returns a new bag that contains only the distinct elements from the current bag. 
     * Discards manifest duplicates to reveal one of every unique item found onboard. 
     */
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        Set<T> optimizationSet = new HashSet<>();
        for (T checkedEntry : this.elementsHold) {
            if (optimizationSet.add(checkedEntry)) {
                distinctBag.add(checkedEntry);
            }
        }
        return distinctBag;
    }

    @Override
    public Iterator<T> iterator() {
        return elementsHold.iterator();
    }

    /** 
     * Prints out a clean visual log representation of the current deck contents. 
     */
    @Override
    public String toString() {
        return elementsHold.toString();
    }
}