package access_modifiers.assignment_problems;

public class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    // Constructor to set all fields
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Method to print formatted inventory entry
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        // Create 4 BookInventory objects and store in an array
        BookInventory[] inventory = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Print each entry in a loop
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}