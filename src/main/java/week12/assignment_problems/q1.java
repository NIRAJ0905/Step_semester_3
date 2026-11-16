package week12.assignment_problems;

class q1 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node build(String[] stops) {
        if (stops == null || stops.length == 0) {
            return null;
        }
        Node head = new Node(stops[0]);
        Node tail = head;
        for (int i = 1; i < stops.length; i++) {
            tail.next = new Node(stops[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0");
            return;
        }

        Node current = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        String[] stops1 = {"Tambaram", "Guindy", "TNagar", "Central"};
        Node route1 = build(stops1);
        printRoute(route1);

        System.out.println();

        String[] stops2 = {"Potheri"};
        Node route2 = build(stops2);
        printRoute(route2);
    }
}