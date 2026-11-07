package week11_sorting;

import java.util.Arrays;

public class Problem3 {

    public static void shelf(int[] books) {
        int n = books.length;
        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            // Move elements greater than key one position to the right
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            System.out.println("After placing " + key + ":");
            System.out.println(Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] books = {30, 10, 40, 20};
        System.out.println("Initial: " + Arrays.toString(books));
        shelf(books);
    }
}