package abstraction_assignment;
import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private int hours;
    private double rate;
    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;
    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff = null;

            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = sc.nextDouble();
                staff = new InternStaff(name, stipend);
            }

            if (staff != null) {
                double pay = staff.calculatePay();
                totalPayroll += pay;
                System.out.printf("%s: %.2f\n", name, pay);
            }
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}