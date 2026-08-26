package string.assigment_problems;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        sumOfNaturalNumbers(n);
        scanner.close();
    }
}