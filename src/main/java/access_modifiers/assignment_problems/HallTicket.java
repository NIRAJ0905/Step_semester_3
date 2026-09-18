package access_modifiers.assignment_problems;

public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Original object and second reference pointing to it
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        // Modifying seatNumber through second reference
        copy.seatNumber = 45;

        // Print field value as seen through first variable
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);

        // Reference equality checks
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}