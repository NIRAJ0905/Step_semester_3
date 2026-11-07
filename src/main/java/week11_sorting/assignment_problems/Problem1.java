package week11_sorting;

import java.util.Arrays;

public class Problem1 {

    public static void lineUp(int[] heights) {
        int n = heights.length;
        boolean swapped;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    // Swap adjacent elements
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;
            
            // If no swaps occurred during this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Input: " + Arrays.toString(heights1));
        lineUp(heights1);
    }
}