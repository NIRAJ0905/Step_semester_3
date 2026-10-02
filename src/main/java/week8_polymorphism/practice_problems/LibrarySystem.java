package polymorphism_practice_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
    public String getTitle() { return title; }
}

class BookItem extends LibraryItem {
    public BookItem(String title) { super(title); }
    @Override public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) { super(title); }
    @Override public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) { super(title); }
    @Override public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        LibraryItem[] items = new LibraryItem[n];
        LocalDate baseDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            if (type.equals("BOOK")) items[i] = new BookItem(title);
            else if (type.equals("DVD")) items[i] = new DVDItem(title);
            else if (type.equals("MAGAZINE")) items[i] = new MagazineItem(title);
        }
        scanner.close();

        for (LibraryItem item : items) {
            LocalDate due = item.calculateDueDate(baseDate);
            System.out.println(item.getTitle() + ": " + due);
        }
    }
}