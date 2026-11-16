package week12.assignment_problems;

public class q4 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(booking)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println(booking + " not found");
        }

        return head;
    }

    public static void printChain(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static Node buildChain(String[] bookings) {
        if (bookings.length == 0) return null;
        Node head = new Node(bookings[0]);
        Node tail = head;
        for (int i = 1; i < bookings.length; i++) {
            tail.next = new Node(bookings[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node b1 = buildChain(new String[]{"104", "101", "107", "101"});
        b1 = removeFirst(b1, "101");
        printChain(b1);

        Node b2 = buildChain(new String[]{"104", "101", "107"});
        b2 = removeFirst(b2, "104");
        printChain(b2);

        Node b3 = buildChain(new String[]{"104", "101"});
        b3 = removeFirst(b3, "200");
        printChain(b3);
    }
}