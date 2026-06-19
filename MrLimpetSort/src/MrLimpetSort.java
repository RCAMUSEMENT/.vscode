import java.util.Arrays; // 

// Just a simple wrapper class named after the classic movie fish character.
public class MrLimpetSort {

    // Classic insertion sort. Think of it like sorting a hand of playing cards:
    // you pick one card at a time and slide it into the right spot on the left.
    public static void insertionSort(int[] schoolOfFish) {
        int n = schoolOfFish.length;

        // Loop through the array, starting at index 1 because index 0 is already "sorted" by itself.
        for (int i = 1; i < n; ++i) {
            int currentFish = schoolOfFish[i]; // Grab the fish we want to place.
            int j = i - 1; // Start looking at the fish right before it.

            // As long as we aren't out of bounds and the fish on the left is bigger, 
            // shift that bigger fish over to make room.
            while (j >= 0 && schoolOfFish[j] > currentFish) {
                schoolOfFish[j + 1] = schoolOfFish[j]; 
                j = j - 1; // Keep moving left.
            }
            
            // Put our current fish into the empty slot we just created.
            schoolOfFish[j + 1] = currentFish;
        }
    }

    public static void main(String[] args) {
        // Some random, messy data to test this out.
        int[] sonarReadings = {82, 43, 27, 38, 3, 10, 9};

        System.out.println(" Unsorted Sonar Array: " + Arrays.toString(sonarReadings));

        // Run the sort and modify the array in place.
        insertionSort(sonarReadings);

        System.out.println(" Perfectly Aligned Array: " + Arrays.toString(sonarReadings));
    }
}