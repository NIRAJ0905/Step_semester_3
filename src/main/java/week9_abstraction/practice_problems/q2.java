package abstraction_practice;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }
    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() {
        return (40.0 + (10.0 * weight)) + 50.0;
    }
    @Override
    public double calculateInsurance(double declaredValue) {
        return 0.02 * declaredValue;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel = null;
            double insurance = 0.0;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                ExpressParcel ep = new ExpressParcel(weight, declaredValue);
                parcel = ep;
                insurance = ep.calculateInsurance(declaredValue);
            } else if (type.equals("FRAGILE")) {
                FragileParcel fp = new FragileParcel(weight, declaredValue);
                parcel = fp;
                insurance = fp.calculateInsurance(declaredValue);
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double total = charge + insurance;
                grandTotal += total;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type, charge, insurance, total);
            }
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}