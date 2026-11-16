package week12.practice_problems;

import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        int roomsBilled = 0;
        int totalBill = 0;

        for (int i = 0; i < n; i++) {
            String room = scanner.next();
            int units = scanner.nextInt();

            if (units < 0) {
                System.out.println(room + ": invalid reading");
            } else {
                int bill = 50;
                if (units <= 100) {
                    bill += units * 3;
                } else if (units <= 200) {
                    bill += (100 * 3) + ((units - 100) * 5);
                } else {
                    bill += (100 * 3) + (100 * 5) + ((units - 200) * 8);
                }
                roomsBilled++;
                totalBill += bill;
                System.out.println(room + ": " + units + " units, bill " + bill);
            }
        }
        scanner.close();

        System.out.println("Rooms billed " + roomsBilled + ", total " + totalBill);
    }
}