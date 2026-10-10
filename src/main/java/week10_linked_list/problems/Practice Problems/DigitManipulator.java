public class DigitManipulator {
    public static void processNumber(int n) {
        int original = n;
        int sum = 0;
        int reversed = 0;
        
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}