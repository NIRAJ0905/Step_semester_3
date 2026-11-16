package week12.practice_problems;

public class q3 {
    private String[] pile = new String[3];
    private int top = -1;

    private String[] line = new String[3];
    private int front = 0;
    private int rear = -1;
    private int lineSize = 0;

    public void returnBook(String book) {
        if (top == 2) {
            System.out.println(book + " rejected: pile is full");
        } else {
            pile[++top] = book;
            System.out.println(book + " placed on pile");
        }
    }

    public void shelveBook() {
        if (top == -1) {
            System.out.println("pile is empty");
        } else {
            System.out.println("shelved " + pile[top--]);
        }
    }

    public void waitStudent(String student) {
        if (lineSize == 3) {
            System.out.println(student + " rejected: line is full");
        } else {
            rear = (rear + 1) % 3;
            line[rear] = student;
            lineSize++;
            System.out.println(student + " joined the line");
        }
    }

    public void serveStudent() {
        if (lineSize == 0) {
            System.out.println("no one waiting");
        } else {
            System.out.println("served " + line[front]);
            front = (front + 1) % 3;
            lineSize--;
        }
    }

    public static void main(String[] args) {
        LibraryReturnDesk desk = new LibraryReturnDesk();
        desk.returnBook("B1");
        desk.returnBook("B2");
        desk.returnBook("B3");
        desk.returnBook("B4");
        desk.waitStudent("Asha");
        desk.waitStudent("Ravi");
        desk.shelveBook();
        desk.serveStudent();
        desk.shelveBook();
        desk.shelveBook();
        desk.shelveBook();
        desk.serveStudent();
        desk.serveStudent();
    }
}