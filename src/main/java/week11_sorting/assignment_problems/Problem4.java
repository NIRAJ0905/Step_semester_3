package week11_sorting;

import java.util.Arrays;

public class Problem4 {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i; // Returns the index of the first break
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Queue: " + Arrays.toString(tokens1));
        System.out.println("First break index: " + firstBreak(tokens1)); // Expected: 4

        int[] tokens2 = {1, 2, 2, 7};
        System.out.println("Queue: " + Arrays.toString(tokens2));
        System.out.println("First break index: " + firstBreak(tokens2)); // Expected: -1
    }
}