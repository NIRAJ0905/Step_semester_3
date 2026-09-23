package week7_encapsulation.assignment_problems;

public class PasswordChecker {
    private final String password; // Private, no getter[cite: 7]

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length(); // Strength based on length[cite: 7]
        if (length < 6) {
            return "Weak"; //[cite: 7]
        } else if (length <= 9) {
            return "Medium"; //[cite: 7]
        } else {
            return "Strong"; //[cite: 7]
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Rating: " + pc1.getStrength()); // Weak[cite: 7]

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("Rating: " + pc2.getStrength()); // Strong[cite: 7]
    }
}