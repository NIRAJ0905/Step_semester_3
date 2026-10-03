package abstraction_assignment;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item = null;

            if (type.equals("BOOK")) {
                item = new BookItem(title, daysLate);
            } else if (type.equals("DVD")) {
                item = new DvdItem(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                item = new MagazineItem(title, daysLate);
            }

            if (item != null) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf("%s: %.2f\n", title, fine);
            }
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}