package access_modifiers.class_problems;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Original object and aliased reference
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;

        // Modifying through the second variable
        duplicate.booksIssued = 3;

        // Print verification
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}