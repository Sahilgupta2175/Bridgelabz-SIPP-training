public class SamAverageMark {
    public static void main(String[] args) {
        // Given marks
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate average
        double average = (maths + physics + chemistry) / 3.0;

        // Print result
        System.out.println("Sam’s average mark in PCM is " + String.format("%.2f", average));
    }
}
