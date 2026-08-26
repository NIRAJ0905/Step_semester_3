package string.class_problems;

import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();

        int n1 = number1;
        int n2 = number2;

        while (n2 != 0) {
            int remainder = n1 % n2;
            n1 = n2;
            n2 = remainder;
        }

        System.out.println("The GCD of " + number1 + " and " + number2 + " is " + n1);

        scanner.close();
    }
}