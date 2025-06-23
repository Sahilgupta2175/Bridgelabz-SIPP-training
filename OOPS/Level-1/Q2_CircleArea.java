public class Q2_CircleArea {

    static class Circle {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        public void displayDetails() {
            System.out.println("Radius        : " + radius);
            System.out.println("Area          : " + getArea());
            System.out.println("Circumference : " + getCircumference());
        }
    }

    public static void main(String[] args) {
        Circle c = new Circle(7.5);
        c.displayDetails();
    }
}
