package com.sweethaven;

import com.sweethaven.collection.Bag;

/**
 * Requirement 3: Write a Java program that demonstrates the usage of the `Bag` class.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println(" ⚓ POPEYE THE SAILOR MULTISET DATA STRUCTURE ORCHESTRATION ⚓ ");
        System.out.println("===============================================================");

        // 3.1. Create an instance of the 'Bag' class.
        System.out.println("\n[STEP 3.1] Creating a new instance of the custom 'Bag' class container...");
        Bag<String> sweetHavenStorage = new Bag<>();

        // 3.2. Add several elements to the bag, including duplicates.
        System.out.println("\n[STEP 3.2] Loading provisions aboard Popeye's vessel hold...");
        sweetHavenStorage.add("Canned Spinach");
        sweetHavenStorage.add("Heavy Anchor");
        sweetHavenStorage.add("Canned Spinach"); // Duplicate 1
        sweetHavenStorage.add("Corncob Pipe");
        sweetHavenStorage.add("Heavy Anchor"); // Duplicate 2
        sweetHavenStorage.add("Canned Spinach"); // Duplicate 3

        // 3.3. Print the bag contents.
        System.out.println("\n[STEP 3.3] Outputting full structural contents profile of the Bag:");
        System.out.println(">>> Hold Layout Manifest: " + sweetHavenStorage);

        // 3.4. Test the 'contains' method for a few elements.
        System.out.println("\n[STEP 3.4] Testing the 'contains' method verification layer...");
        System.out.println("Contains 'Canned Spinach'?: " + sweetHavenStorage.contains("Canned Spinach"));
        System.out.println("Contains 'Bluto's Malice'?: " + sweetHavenStorage.contains("Bluto's Malice"));

        // 3.5. Test the 'count' method for a few elements.
        System.out.println("\n[STEP 3.5] Testing the 'count' tracking method for density metrics...");
        System.out.println("Count for 'Canned Spinach': " + sweetHavenStorage.count("Canned Spinach"));
        System.out.println("Count for 'Heavy Anchor': " + sweetHavenStorage.count("Heavy Anchor"));
        System.out.println("Count for 'Bluto's Malice': " + sweetHavenStorage.count("Bluto's Malice"));

        // 3.6. Remove an element from the bag.
        System.out.println("\n[STEP 3.6] Popeye eats one 'Canned Spinach' for a massive power boost...");
        sweetHavenStorage.remove("Canned Spinach");

        // 3.7. Print the bag contents again.
        System.out.println("\n[STEP 3.7] Printing updated bag contents layout immediately following removal:");
        System.out.println(">>> Updated Hold Layout Manifest: " + sweetHavenStorage);

        // 3.8. Test the 'contains' method for the removed element.
        System.out.println("\n[STEP 3.8] Testing the 'contains' validation layer on the removed target...");
        System.out.println("Does bag still contain 'Canned Spinach'?: " + sweetHavenStorage.contains("Canned Spinach"));

        // 3.9. Test the 'count' method for the removed element.
        System.out.println("\n[STEP 3.9] Testing the final 'count' value calculation metric post-removal...");
        System.out.println("New remaining inventory tally for 'Canned Spinach': " + sweetHavenStorage.count("Canned Spinach"));

        System.out.println("\n⚓ PROCESS ARCHITECTURE EXECUTED SUCCESSFULLY. WELL WISHES TO SWEETHAVEN!");
    }
}