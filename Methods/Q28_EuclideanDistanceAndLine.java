public class Q28_EuclideanDistanceAndLine {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] lineEquation(int x1, int y1, int x2, int y2) {
        double m = (double) (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[] { m, b };
    }

    public static void main(String[] args) {
        int x1 = 2, y1 = 3, x2 = 5, y2 = 7;

        double d = distance(x1, y1, x2, y2);
        double[] eq = lineEquation(x1, y1, x2, y2);

        System.out.printf("Distance: %.2f\n", d);
        System.out.printf("Equation: y = %.2fx + %.2f\n", eq[0], eq[1]);
    }
}
