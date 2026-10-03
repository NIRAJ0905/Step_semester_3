package abstraction_practice;
import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.00;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double calculateAmount();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return count * (150.0 + CONVENIENCE_FEE);
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return count * (250.0 + CONVENIENCE_FEE);
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    @Override
    public double calculateAmount() {
        return count * (400.0 + CONVENIENCE_FEE);
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket ticket = null;

            if (type.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (type.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else if (type.equals("RECLINER")) {
                ticket = new ReclinerTicket(count);
            }

            if (ticket != null) {
                double amt = ticket.calculateAmount();
                total += amt;
                System.out.printf("%s: %.2f\n", type, amt);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}