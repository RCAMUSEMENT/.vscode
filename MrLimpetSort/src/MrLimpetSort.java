import java.util.Arrays;  

public class MrLimpetSort {

    public static void insertionSort(int[] schoolOfFish) {
        int n = schoolOfFish.length;
        
        for (int i = 1; i < n; ++i) {
            int currentFish = schoolOfFish[i];
            int j = i - 1;

            while (j >= 0 && schoolOfFish[j] > currentFish) {
                schoolOfFish[j + 1] = schoolOfFish[j];
                j = j - 1;
            }
            schoolOfFish[j + 1] = currentFish;
        }
    }

    public static void main(String[] args) {
        int[] sonarReadings = {82, 43, 27, 38, 3, 10, 9};
        
        System.out.println(" Unsorted Sonar Array: " + Arrays.toString(sonarReadings));
        
        insertionSort(sonarReadings);
        
        System.out.println(" Perfectly Aligned Array: " + Arrays.toString(sonarReadings));
    }
}