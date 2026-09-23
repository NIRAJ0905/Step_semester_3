package week7_encapsulation.assignment_problems;

public class TrafficLight {
    private final String id;  // Fixed ID[cite: 7]
    private String color;     // Private color field[cite: 7]

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Starts on RED[cite: 7]
    }

    public void next() {
        // Enforces strict cyclic sequence: RED -> GREEN -> YELLOW -> RED[cite: 7]
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
        }
    }

    public String getColor() {
        return color; // Read-only check[cite: 7]
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Color: " + t.getColor()); // RED[cite: 7]
        t.next();
        System.out.println("Color: " + t.getColor()); // GREEN[cite: 7]
        t.next();
        System.out.println("Color: " + t.getColor()); // YELLOW[cite: 7]
        t.next();
        System.out.println("Color: " + t.getColor()); // RED[cite: 7]
    }
}