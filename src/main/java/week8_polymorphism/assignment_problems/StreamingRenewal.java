package polymorphism_assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;
    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    public abstract LocalDate calculateRenewalDate();
    public String getName() { return name; }
}

class BasicSubscription extends Subscription {
    public BasicSubscription(String n, LocalDate d) { super(n, d); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardSubscription extends Subscription {
    public StandardSubscription(String n, LocalDate d) { super(n, d); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumSubscription extends Subscription {
    public PremiumSubscription(String n, LocalDate d) { super(n, d); }
    @Override public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Subscription[] subs = new Subscription[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate date = LocalDate.parse(scanner.next());

            if (type.equals("BASIC")) subs[i] = new BasicSubscription(name, date);
            else if (type.equals("STANDARD")) subs[i] = new StandardSubscription(name, date);
            else if (type.equals("PREMIUM")) subs[i] = new PremiumSubscription(name, date);
        }
        scanner.close();

        for (Subscription sub : subs) {
            LocalDate renewal = sub.calculateRenewalDate();
            System.out.println(sub.getName() + ": " + renewal);
        }
    }
}