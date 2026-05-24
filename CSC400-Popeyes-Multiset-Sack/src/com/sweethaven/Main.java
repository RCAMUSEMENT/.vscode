/**
 * Popeye's Nautical Multiset Cargo Hold
 * Student Name: Ryley Carlson
 * Course: CSC400 Module 2 Critical Thinking Assignment
 * Date: 2026-05-24
 * Program: Main.java
 * Description: An orchestration program that demonstrates a generic Bag (multiset)
 * data structure container. The application verifies adding, removing, containing,
 * size monitoring, merging, and distinct filtering operations using a Popeye theme.
 */
package com.sweethaven;

import com.sweethaven.collection.Bag;

/**
 * Requirement #3: I wrote a Java program that demonstrates the usage of the `Bag` class.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println(" POPEYE THE SAILOR MAN'S MULTISET DATA STRUCTURE ORCHESTRATION ");
        System.out.println("===============================================================");

        // Requirement #3.1. Create an instance of the 'Bag' class.
        System.out.println("\n[REQUIREMENT 3.1] Creating a new instance of the custom 'Bag' class container...");
        Bag<String> sweetHavenStorage = new Bag<>();

        // Requirement #3.2. Add several elements to the bag, including some duplicates.
        System.out.println("\n[REQUIREMENT 3.2] Loading provisions aboard Popeye's vessel hold...");
        sweetHavenStorage.add("Canned Spinach");
        sweetHavenStorage.add("Pipe Tobacco");
        sweetHavenStorage.add("Canned Spinach"); // Duplicate #1
        sweetHavenStorage.add("Corncob Pipe");
        sweetHavenStorage.add("Pipe Tobacco"); // Duplicate #2
        sweetHavenStorage.add("Canned Spinach"); // Duplicate #3

        // Requirement #3.3. Print the bag contents.
        System.out.println("\n[REQUIREMENT 3.3] Outputting full structural contents profile of the Bag:");
        System.out.println(">>> Hold Layout Manifest: " + sweetHavenStorage);

        // Requirement #3.4. Test the 'contains' method for a few elements.
        System.out.println("\n[REQUIREMENT 3.4] Testing the 'contains' method verification layer...");
        System.out.println("Contains 'Canned Spinach'?: " + sweetHavenStorage.contains("Canned Spinach"));
        System.out.println("Contains 'Bluto's Blood feud'?: " + sweetHavenStorage.contains("Bluto's Blood feud"));

        // Requirement #3.5. Test the 'count' method for a few elements.
        System.out.println("\n[REQUIREMENT 3.5] Testing the 'count' tracking method for density metrics...");
        System.out.println("Count for 'Canned Spinach': " + sweetHavenStorage.count("Canned Spinach"));
        System.out.println("Count for 'Pipe Tobacco': " + sweetHavenStorage.count("Pipe Tobacco"));
        System.out.println("Count for 'Bluto's Blood feud': " + sweetHavenStorage.count("Bluto's Blood feud"));

        // Requirement #3.6. Remove an element from the bag.
        System.out.println("\n[REQUIREMENT 3.6] Popeye eats one 'Canned Spinach' for a massive power boost...");
        sweetHavenStorage.remove("Canned Spinach");

        // Requirement #3.7. Print the bag contents again.
        System.out.println("\n[REQUIREMENT 3.7] Printing updated bag contents layout immediately following removal:");
        System.out.println(">>> Updated Hold Layout Manifest: " + sweetHavenStorage);

        // Requirement #3.8. Test the 'contains' method for the removed element.
        System.out.println("\n[REQUIREMENT 3.8] Testing the 'contains' validation layer on the removed target...");
        System.out.println("Does bag still contain 'Canned Spinach'?: " + sweetHavenStorage.contains("Canned Spinach"));

        // Requirement #3.9. Test the 'count' method for the removed element.
        System.out.println("\n[REQUIREMENT 3.9] Testing the final 'count' value calculation metric post-removal...");
        System.out.println("New remaining inventory tally for 'Canned Spinach': " + sweetHavenStorage.count("Canned Spinach"));


        // =========================================================================
        // NEW ADDITIONS FOR CRITICAL THINKING ASSIGNMENT WEEK 2: MAIN WORKFLOW EXTENSIONS
        // =========================================================================
        System.out.println("\n===============================================================");
        System.out.println("   MODULE 2 EXTENSION: SIZE, MERGING, AND DISTINCT FILTERS     ");
        System.out.println("===============================================================");

        // Assignment Requirement: Create two instances of the bag class
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Commissioning a second vessel cargo hold (Olive Oyl's Hold)...");
        Bag<String> oliveOylHold = new Bag<>();

        // Assignment Requirement: Add elements to each bag, including duplicates
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Loading separate unique provisions into Olive Oyl's hold...");
        oliveOylHold.add("Pipe Tobacco"); // Duplicate matching sweetHavenStorage
        oliveOylHold.add("Anchor");
        oliveOylHold.add("Sea Biscuit");
        oliveOylHold.add("Anchor"); // Internal duplicate

        // Assignment Requirement: Print the size of each bag using the size method
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Verifying total cargo unit counts via size() method...");
        System.out.println(">>> Popeye's Sweet Haven Hold Size: " + sweetHavenStorage.size());
        System.out.println(">>> Olive Oyl's Hold Size: " + oliveOylHold.size());

        // Assignment Requirement: Merge the two bags together using the merge method
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Transferring all elements from Olive Oyl's hold into Popeye's hold...");
        sweetHavenStorage.merge(oliveOylHold);

        // Assignment Requirement: Print the merged bag contents
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Outputting combined fleet hold layout post-merge:");
        System.out.println(">>> Combined Manifest: " + sweetHavenStorage);

        // Assignment Requirement: Create a new bag containing only the distinct elements
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Isolating singular unique items using distinct() method...");
        Bag<String> distinctCatalog = sweetHavenStorage.distinct();

        // Assignment Requirement: Print the distinct bag contents
        System.out.println("\n[CRITICAL THINKING ASSIGNMENT 2] Outputting final distinct catalog blueprint profile:");
        System.out.println(">>> Distinct Manifest Catalog: " + distinctCatalog);

        System.out.println("\n THE PROCESS ARCHITECTURE HAS BEEN EXECUTED SUCCESSFULLY. WELL WISHES TO SWEETHAVEN!");
    }
}