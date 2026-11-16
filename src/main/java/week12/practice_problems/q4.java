package week12.practice_problems;

import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    String getModeName();
}

class CashPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount * 1.02;
    }

    @Override
    public String getModeName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "UPI";
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        PaymentMode[] modes = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            amounts[i] = scanner.nextDouble();

            if (mode.equals("Cash")) {
                modes[i] = new CashPayment();
            } else if (mode.equals("Card")) {
                modes[i] = new CardPayment();
            } else {
                modes[i] = new UpiPayment();
            }
        }
        scanner.close();

        double totalProcessed = 0.0;
        for (int i = 0; i < n; i++) {
            double processed = modes[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];
            totalProcessed += processed;
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f\n",
                    modes[i].getModeName(), amounts[i], fee, processed);
        }
        System.out.printf("Total Amount Processed: %.1f\n", totalProcessed);
    }
}