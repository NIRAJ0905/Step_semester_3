public class EvenOddCounter {
    public static void countEvenOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}