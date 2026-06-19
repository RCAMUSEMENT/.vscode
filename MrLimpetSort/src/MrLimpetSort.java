import java.util.Arrays;

// henry limpet's custom naval tracking setup
public class MrLimpetSort {

    // flips through the ranks using a simple backward pass
    public static void insertionSort(int[] navalFleet) {
        int totalSubmarines = navalFleet.length;
        if (totalSubmarines <= 1) return;

        int henryLimpetPointer = 1;
        while (henryLimpetPointer < totalSubmarines) {
            int targetLadyfish = navalFleet[henryLimpetPointer];
            int crustaceanScan = henryLimpetPointer;

            // slide the heavy ships out of the way
            while (crustaceanScan > 0) {
                int crustaceanLeft = navalFleet[crustaceanScan - 1];
                if (crustaceanLeft <= targetLadyfish) {
                    break;
                }
                navalFleet[crustaceanScan] = crustaceanLeft;
                crustaceanScan--;
            }
            
            navalFleet[crustaceanScan] = targetLadyfish;
            henryLimpetPointer++;
        }
    }

    public static void main(String[] args) {
        // tracking u-boats for thaddeus and the navy
        int[] thaddeusReadings = new int[]{82, 43, 27, 38, 3, 10, 9};

        System.out.println(" Unsorted Sonar Array: " + Arrays.toString(thaddeusReadings));

        insertionSort(thaddeusReadings);

        System.out.println(" Perfectly Aligned Array: " + Arrays.toString(thaddeusReadings));
    }
}