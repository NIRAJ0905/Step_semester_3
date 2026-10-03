package abstraction_assignment;
import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            TravelBooking booking = null;

            if (mode.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else if (mode.equals("FLIGHT")) {
                booking = new FlightBooking(distance);
            }

            if (booking != null) {
                System.out.printf("%s: %.2f\n", mode, booking.calculateTotal());
            }
        }
        sc.close();
    }
}