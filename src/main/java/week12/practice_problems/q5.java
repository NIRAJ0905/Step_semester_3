package week12.practice_problems;

import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] rainfall = new double[7];

        for (int i = 0; i < 7; i++) {
            if (scanner.hasNextDouble()) {
                rainfall[i] = scanner.nextDouble();
            }
        }
        scanner.close();

        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        System.out.print("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            System.out.print(" " + rainfall[i]);
            total += rainfall[i];
            if (rainfall[i] > rainfall[wettestIndex]) {
                wettestIndex = i;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }
        System.out.println();

        double average = total / 7.0;
        System.out.printf("Total Rainfall: %.1f mm\n", total);
        System.out.printf("Average Rainfall: %.2f mm\n", average);
        System.out.printf("Wettest Day: Day %d (%.1f mm)\n", (wettestIndex + 1), rainfall[wettestIndex]);
        System.out.println("Total Dry Days: " + dryDays);
    }
}