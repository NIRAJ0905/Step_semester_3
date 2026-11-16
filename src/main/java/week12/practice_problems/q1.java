package week12.practice_problems;

import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    public Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public String getRole() {
        return "Staff";
    }
}

class Teacher extends Staff {
    public Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    public LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getRole() {
        return "LabAssistant";
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double base = scanner.nextDouble();

            if (type.equals("Teacher")) {
                staffList[i] = new Teacher(name, base);
            } else if (type.equals("LabAssistant")) {
                staffList[i] = new LabAssistant(name, base);
            } else {
                staffList[i] = new Staff(name, base);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Staff s : staffList) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;
            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f\n",
                    s.name, s.getRole(), s.baseSalary, bonus, total);
        }
        System.out.printf("Grand Total Salary: %.1f\n", grandTotal);
    }
}