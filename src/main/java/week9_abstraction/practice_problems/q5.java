package abstraction_practice;
import java.util.Scanner;

interface SaverModeSupport {
    double applySaverMode(double units);
}

abstract class Appliance {
    protected int hours;
    protected boolean saverRequested;

    public Appliance(int hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public abstract double getPowerRating();

    public double calculateUnits() {
        return (getPowerRating() * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(int hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 150.0; }
}

class AirConditioner extends Appliance implements SaverModeSupport {
    public AirConditioner(int hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 1500.0; }
    @Override
    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    public TV(int hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 100.0; }
}

class WashingMachine extends Appliance implements SaverModeSupport {
    public WashingMachine(int hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 500.0; }
    @Override
    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int hours = sc.nextInt();
            boolean saver = sc.hasNext("SAVER");
            if (saver) sc.next(); // consume "SAVER" token

            if (saver && (name.equals("FRIDGE") || name.equals("TV"))) {
                System.out.println(name + ": saver mode not supported");
                continue;
            }

            Appliance app = null;
            if (name.equals("FRIDGE")) {
                app = new Fridge(hours, saver);
            } else if (name.equals("AC")) {
                app = new AirConditioner(hours, saver);
            } else if (name.equals("TV")) {
                app = new TV(hours, saver);
            } else if (name.equals("WASHER")) {
                app = new WashingMachine(hours, saver);
            }

            if (app != null) {
                double units = app.calculateUnits();
                if (saver && app instanceof SaverModeSupport) {
                    units = ((SaverModeSupport) app).applySaverMode(units);
                }
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", name, units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}