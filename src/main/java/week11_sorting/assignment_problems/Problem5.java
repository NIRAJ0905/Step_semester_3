package week11_sorting;

import java.util.Arrays;

public class Problem5 {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7]; // Indices 1 to 6 for dice faces

        // Count frequencies
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        // Print counts format
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + " ");
        }
        System.out.println();

        // Reconstruct sorted array
        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sortedRolls[index++] = v;
            }
        }

        return sortedRolls;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Input rolls: " + Arrays.toString(rolls));
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}