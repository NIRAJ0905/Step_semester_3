package week7_encapsulation.practice_problems;

public class AttendanceSheet {
    private final String[] presentStudents; // Private array[cite: 6]
    private int presentCount;               // Keeps track of unique count[cite: 6]

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (!isPresent(studentName) && presentCount < presentStudents.length) { // Prevents duplicates[cite: 6]
            presentStudents[presentCount] = studentName;
            presentCount++;
        }
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return presentCount; // Count only, no array exposed[cite: 6]
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate ignored[cite: 6]

        System.out.println("Present Count: " + sheet.getPresentCount()); // 2[cite: 6]
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));   // true[cite: 6]
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // false[cite: 6]
    }
}