public class Q14_EuclideanLine {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] lineEquation(int x1, int y1, int x2, int y2) {
        double m = (double) (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[] { m, b };
    }

    public static void main(String[] args) {
        System.out.println("Distance: " + distance(2, 3, 5, 7));
        double[] eq = lineEquation(2, 3, 5, 7);
        System.out.printf("Line: y = %.2fx + %.2f\n", eq[0], eq[1]);
    }
}
