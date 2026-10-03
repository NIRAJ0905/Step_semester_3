package abstraction_practice;
import java.util.Scanner;

interface TransportUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    protected static final double BUS_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();
}

class DayScholar extends Student implements TransportUser {
    public DayScholar(String name) { super(name); }
    @Override
    public double calculateFee() {
        return 40000.0 + getTransportFee();
    }
    @Override
    public double getTransportFee() {
        return BUS_FEE;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override
    public double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student implements TransportUser {
    public Scholar(String name) { super(name); }
    @Override
    public double calculateFee() {
        return 20000.0 + getTransportFee();
    }
    @Override
    public double getTransportFee() {
        return BUS_FEE;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = null;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                student = new Scholar(name);
            }

            if (student != null) {
                double fee = student.calculateFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", name, fee);
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}