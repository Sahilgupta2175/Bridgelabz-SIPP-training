public class Q2_Circle {
    private double radius;

    public Q2_Circle() {
        this(1.0);
    }

    public Q2_Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {
        Q2_Circle circle1 = new Q2_Circle();
        circle1.displayDetails();

        System.out.println("\n");

        Q2_Circle circle2 = new Q2_Circle(5.0);
        circle2.displayDetails();
    }
}
