package week7_encapsulation.practice_problems;

public class Locker {
    private final int lockerNumber; // Fixed locker number[cite: 6]
    private String combinationCode;  // Private code with NO getter[cite: 6]

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("Combination code changed successfully."); //[cite: 6]
        } else {
            System.out.println("Change rejected: Incorrect current code."); //[cite: 6]
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // Success[cite: 6]
        l.changeCode("0000", "9999"); // Rejected[cite: 6]
    }
}