package access_modifiers.class_problems;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor to set all fields
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Method to print formatted record
    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        // Create 3 PlacementRecord objects and store in an array
        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        // Print each in a loop
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}