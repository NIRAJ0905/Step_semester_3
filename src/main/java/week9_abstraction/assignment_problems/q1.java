package abstraction_assignment;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public abstract String getShapeName();
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String getShapeName() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
    @Override
    public String getShapeName() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    @Override
    public String getShapeName() { return "TRIANGLE"; }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot = null;

            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new TrianglePlot(owner, base, height);
            }

            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", owner, plot.getShapeName(), area);
            }
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}