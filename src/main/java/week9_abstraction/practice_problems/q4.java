package abstraction_practice;
import java.util.Scanner;

interface NightServiceable {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double calculateBaseFare();
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) { super(km, time); }
    @Override
    public double calculateBaseFare() {
        double fare = km * 10.0;
        return Math.max(fare, 100.0);
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) { super(km, time); }
    @Override
    public double calculateBaseFare() {
        double fare = km * 14.0;
        return Math.max(fare, 100.0);
    }
    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double km, String time) { super(km, time); }
    @Override
    public double calculateBaseFare() {
        double fare = km * 18.0;
        return Math.max(fare, 100.0);
    }
    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (cabType.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab cab = null;
            if (cabType.equals("MINI")) {
                cab = new MiniCab(km, time);
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab(km, time);
            } else if (cabType.equals("SUV")) {
                cab = new SuvCab(km, time);
            }

            if (cab != null) {
                double fare = cab.calculateBaseFare();
                if (time.equals("NIGHT") && cab instanceof NightServiceable) {
                    fare = ((NightServiceable) cab).applyNightSurcharge(fare);
                }
                total += fare;
                System.out.printf("%s: %.2f\n", cabType, fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}