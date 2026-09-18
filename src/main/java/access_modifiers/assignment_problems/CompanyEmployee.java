package access_modifiers.assignment_problems;

public class CompanyEmployee {
    String empName;
    double salary;

    // Static fields shared across all employee instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increments once per instantiation
    }

    // Static method without accessing instance fields
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Alice", 50000);
        CompanyEmployee e2 = new CompanyEmployee("Bob", 55000);
        CompanyEmployee e3 = new CompanyEmployee("Charlie", 60000);

        // Called via class name
        CompanyEmployee.printCompanyInfo();
    }
}