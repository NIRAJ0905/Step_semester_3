package week11_sorting;

import java.util.Arrays;

public class Problem2 {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            // Scan remaining elements for the maximum mark
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if maxIndex is different from i
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swapCount++;
            }
        }

        System.out.println(Arrays.toString(marks));
        return swapCount;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        System.out.println("Input: " + Arrays.toString(marks1));
        int swaps1 = prizeTable(marks1);
        System.out.println("swaps = " + swaps1);

        System.out.println();
        int[] marks2 = {80, 70, 60};
        System.out.println("Input: " + Arrays.toString(marks2));
        int swaps2 = prizeTable(marks2);
        System.out.println("swaps = " + swaps2);
    }
}