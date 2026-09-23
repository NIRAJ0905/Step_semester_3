package week7_encapsulation.practice_problems;

public class NameTag {
    private final String firstName; // Final immutable fields[cite: 6]
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" "); // Splits on single space[cite: 6]
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + "."; // Builds "FirstName L."[cite: 6]
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname()); // "Maria G."[cite: 6]
    }
}