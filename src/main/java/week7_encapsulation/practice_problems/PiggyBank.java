package week7_encapsulation.practice_problems;

public class PiggyBank {
    private final String id; // Fixed ID set at creation[cite: 6]
    private double savings;  // Private savings field[cite: 6]

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0; // Starts at 0[cite: 6]
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount; // Adds exact amount[cite: 6]
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected: insufficient savings or invalid amount."); //[cite: 6]
        }
    }

    public double getSavings() {
        return savings; // Read-only access[cite: 6]
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings()); // 100.0[cite: 6]
        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings()); // 70.0[cite: 6]
        pb.withdraw(500); // Rejected[cite: 6]
        System.out.println("Savings: " + pb.getSavings()); // 70.0[cite: 6]
    }
}